package com.vampire.RetailService.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "OrderDetails")
public class OrderRequest {
	
	@Id
	private Long id;

	@NotEmpty(message = "name must not be empty")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "OrderRequest [id=" + id + ", name=" + name + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

}
