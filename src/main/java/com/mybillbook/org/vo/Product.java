package com.mybillbook.org.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {

	
	private Long productId;
	private String productName;
	private String productPrice;
	private String storeId;
	public Product(String productName, String productPrice, String storeId) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.storeId = storeId;
	}
	
	
}
