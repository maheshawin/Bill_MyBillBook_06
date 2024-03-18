package com.mybillbook.org.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Store {
	
	private Long storeId;
	private String storeType;
	private String storeName;
	private String Address;
	private String gstNo;
	private String userId;
	public Store(String storeType, String storeName, String address, String gstNo, String userId) {
		super();
		this.storeType = storeType;
		this.storeName = storeName;
		Address = address;
		this.gstNo = gstNo;
		this.userId = userId;
	}
	
	

	
	
}