package com.vampire.RetailsService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vampire.RetailService.controllers.RetailController;
import com.vampire.RetailService.exceptions.ProductNotFoundException;
import com.vampire.RetailService.model.CurrentPrice;
import com.vampire.RetailService.model.OrderRequest;
import com.vampire.RetailService.model.OrderResponse;
import com.vampire.RetailService.service.RetailService;

@RunWith(SpringJUnit4ClassRunner.class)
public class RetailControllerTest {

	@InjectMocks
	RetailController retailController;

	@Mock
	RetailService retailService;

	@Test(expected = ProductNotFoundException.class)
	public void getProductDetailsExceptionTest() throws ProductNotFoundException {
		Mockito.when(retailService.getProduct(Mockito.anyLong())).thenThrow(new ProductNotFoundException(""));
		retailController.getProductDetails(Mockito.anyLong());
	}

	@Test
	public void getProductDetailsTest() throws ProductNotFoundException {
		OrderResponse order = new OrderResponse();
		OrderRequest product = new OrderRequest();
		product.setName("Target");
		order.setOrderRequest(product);
		Mockito.when(retailService.getProduct(Mockito.anyLong())).thenReturn(order);
		assertSame("Target", retailController.getProductDetails(Mockito.anyLong()).getBody().getOrderRequest().getName());
	}

	@Test
	public void getCurrentPriceTest() throws ProductNotFoundException {
		CurrentPrice price = new CurrentPrice();
		price.setValue(12.45D);
		Mockito.when(retailService.getPrice(Mockito.anyLong())).thenReturn(price);
		assertEquals("12.45", retailController.getCurrentPrice(Mockito.anyLong()).getBody().getValue().toString());
	}

	@Test
	public void UpdateCurrentPriceTest() throws ProductNotFoundException {
		CurrentPrice upadtedPrice = new CurrentPrice();
		upadtedPrice.setValue(23D);
		upadtedPrice.setProductId(111L);
		Mockito.when(retailService.updateCurrentPrice(Mockito.any(CurrentPrice.class))).thenReturn(upadtedPrice);
		assertEquals("23.0", retailController.updateProductOrder(upadtedPrice).getValue().toString());

	}

}
