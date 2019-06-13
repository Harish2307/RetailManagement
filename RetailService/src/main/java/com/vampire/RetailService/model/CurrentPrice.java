package com.vampire.RetailService.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="ProductCatalog")
@JsonIgnoreProperties(value={"productId"}, allowSetters= true)
public class CurrentPrice {

	private Double value;
	
	@Id
	@JsonProperty("productId")
	private Long productId;
	
	@NotBlank
	private String currencyCode;

	public Double getValue() {
		return value;
	}
	@JsonIgnore
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	@Override
	public String toString() {
		return "CurrentPrice [value=" + value + ", productId=" + productId + ", currencyCode=" + currencyCode + "]";
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}
