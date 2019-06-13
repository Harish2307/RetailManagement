package com.vampire.RetailService.controllers;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vampire.RetailService.exceptions.ProductNotFoundException;
import com.vampire.RetailService.model.CurrentPrice;
import com.vampire.RetailService.model.OrderResponse;
import com.vampire.RetailService.service.RetailService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/products")
public class RetailController {

	@Autowired
	private RetailService retailService;

	Logger logger = Logger.getLogger(RetailController.class);

	
	@ApiOperation(value = "This API is to Fecth the Product data using product Id")
	@RequestMapping(value = "/getProductData/{productId}", method = RequestMethod.GET, produces = {"application/json"})
	public ResponseEntity<OrderResponse> getProductDetails(@PathVariable("productId") Long productId)
			throws ProductNotFoundException {
		logger.info("Fetching the product information for Product Id:" + productId);
		OrderResponse response = retailService.getProduct(productId);

		return new ResponseEntity<OrderResponse>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "This API is to Fecth the current price using product Id")
	@RequestMapping(value = "/getPrice/{productId}", method = RequestMethod.GET, produces = {"application/json"})
	public ResponseEntity<CurrentPrice> getCurrentPrice(@PathVariable("productId") Long productId)
			throws ProductNotFoundException {
		logger.info("Fetching the product current price for Product Id:" + productId);
		CurrentPrice price = retailService.getPrice(productId);
		return new ResponseEntity<CurrentPrice>(price, HttpStatus.OK);
	}

	@ApiOperation(value = "This API is to to update the current price of Product")
	@RequestMapping(value = "/updatePrice/{productId}", method = { RequestMethod.PUT,RequestMethod.POST }, produces = {"application/json"})
	public CurrentPrice updateProductOrder(@RequestBody CurrentPrice productPrice) throws ProductNotFoundException {
		logger.info("Updating the product current price for Product Id:" + productPrice.getProductId());
		return retailService.updateCurrentPrice(productPrice);
	}
}