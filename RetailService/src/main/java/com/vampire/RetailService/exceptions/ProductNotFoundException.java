package com.vampire.RetailService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Product Not Found for Given productId")
public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = -9079454849611061074L;

	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(final String message) {
		super(message);
	}

}