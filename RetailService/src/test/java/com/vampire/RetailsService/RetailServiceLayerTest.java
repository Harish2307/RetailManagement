package com.vampire.RetailsService;

import static org.junit.Assert.assertEquals;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.vampire.RetailService.exceptions.ProductNotFoundException;
import com.vampire.RetailService.model.CurrentPrice;
import com.vampire.RetailService.model.OrderRequest;
import com.vampire.RetailService.repository.CurrentPriceRepository;
import com.vampire.RetailService.repository.RetailRepository;
import com.vampire.RetailService.service.impl.RetailServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class RetailServiceLayerTest {

	@InjectMocks
	private RetailServiceImpl service;

	@Mock
	private RetailRepository retailRepository;

	@Mock
	private CurrentPriceRepository currentPriceRepository;

	@Mock
	private RestTemplate restTemplate;

	private CurrentPrice price;

	@Before
	public void runBeforeTestMethod() {
		price = new CurrentPrice();
		price.setValue(23.23D);
		price.setProductId(1234L);
	}

	@Test
	public void getPriceTest() throws ProductNotFoundException {
		Mockito.when(currentPriceRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(price));
		assertEquals("23.23", service.getPrice(Mockito.anyLong()).getValue().toString());
	}

	@Test(expected=ProductNotFoundException.class)
	public void getPriceExceptionTest() throws ProductNotFoundException {
		Mockito.when(currentPriceRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		service.getPrice(Mockito.anyLong());
	}

	@Test
	public void getProductTest() throws ProductNotFoundException {
		OrderRequest order=new OrderRequest();
		order.setName("Target");
		Mockito.when(retailRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(order));
		assertEquals("Target", service.getProduct(Mockito.anyLong()).getOrderRequest().getName());
	}

	@Test(expected=ProductNotFoundException.class)
	public void getProductExceptionTest() throws ProductNotFoundException {
		Mockito.when(retailRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		 service.getProduct(Mockito.anyLong());
	}

	
	@Test
	public void updatePriceTest() throws ProductNotFoundException {
		Mockito.when(currentPriceRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(price));
		Mockito.when(currentPriceRepository.save(price)).thenReturn(price);
		assertEquals("23.23", service.updateCurrentPrice(price).getValue().toString());
	}
	@Test(expected=ProductNotFoundException.class)
	public void updatePriceExceptionTest() throws ProductNotFoundException {
		Mockito.when(currentPriceRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		service.updateCurrentPrice(price);
	}
}
