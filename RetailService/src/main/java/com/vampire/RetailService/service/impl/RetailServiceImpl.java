package com.vampire.RetailService.service.impl;


import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vampire.RetailService.exceptions.ProductNotFoundException;
import com.vampire.RetailService.model.CurrentPrice;
import com.vampire.RetailService.model.OrderRequest;
import com.vampire.RetailService.model.OrderResponse;
import com.vampire.RetailService.repository.CurrentPriceRepository;
import com.vampire.RetailService.repository.RetailRepository;
import com.vampire.RetailService.service.RetailService;

@Service
public class RetailServiceImpl implements RetailService {

	
	private static final Logger logger=Logger.getLogger(RetailServiceImpl.class);
	
	@Autowired
	private RetailRepository retailRepository;

	@Autowired
	private CurrentPriceRepository currentPriceRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${product.price.url}")
	private String PRICE_URL;

	@Override
	public OrderResponse getProduct(Long productId) throws ProductNotFoundException {

		OrderRequest order = retailRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException(productId.toString()));
		logger.info("fetching the current by calling the Rest API: "+PRICE_URL);
		CurrentPrice price = restTemplate.getForObject(PRICE_URL, CurrentPrice.class, productId);
		OrderResponse response = new OrderResponse();
		response.setOrderRequest(order);
		response.setPrice(price);
		logger.info("product details for product id "+productId +" is "+response);
		return response;
	}

	@Override
	public CurrentPrice getPrice(Long productId) throws ProductNotFoundException {
		return currentPriceRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId.toString()));
	}

	@Override
	public CurrentPrice updateCurrentPrice(CurrentPrice price) throws ProductNotFoundException {
		currentPriceRepository.findById(price.getProductId()).orElseThrow(()-> new ProductNotFoundException(price.getProductId().toString()));
		return currentPriceRepository.save(price);
	}

}