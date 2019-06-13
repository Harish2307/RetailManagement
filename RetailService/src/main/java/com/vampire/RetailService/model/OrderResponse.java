package com.vampire.RetailService.model;


public class OrderResponse {

	private OrderRequest orderRequest;
	public OrderRequest getOrderRequest() {
		return orderRequest;
	}

	public void setOrderRequest(OrderRequest order) {
		this.orderRequest = order;
	}

	private CurrentPrice price;

	public CurrentPrice getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "OrderResponse [orderRequest=" + orderRequest + ", price=" + price + "]";
	}

	public void setPrice(CurrentPrice price) {
		this.price = price;
	}

}
