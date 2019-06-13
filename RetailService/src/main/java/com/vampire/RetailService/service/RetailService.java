package com.vampire.RetailService.service;


import com.vampire.RetailService.exceptions.ProductNotFoundException;
import com.vampire.RetailService.model.CurrentPrice;
import com.vampire.RetailService.model.OrderResponse;

public interface RetailService {

	public OrderResponse getProduct(Long productId) throws ProductNotFoundException;

	public CurrentPrice getPrice(Long productId) throws ProductNotFoundException;

	public CurrentPrice updateCurrentPrice(CurrentPrice productPrice) throws ProductNotFoundException;
}
