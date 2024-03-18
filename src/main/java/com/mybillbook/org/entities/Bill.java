package com.mybillbook.org.entities;

import java.util.Date;
import java.util.List;

import com.mybillbook.org.vo.Store;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="bill")
public class Bill{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long billId;
	private String phoneNumber;
	private String customerName;
	private Date date;
	private float price;
	private String pdf;	
	private long storeId;
	
	@Transient
	private Store store;
	
	@Transient
	List<BillProducts>  billProducts;
	
	
	
	
		
	public Bill(String phoneNumber, String customerName, Date date, String pdf, long storeId) {
		super();
		this.phoneNumber = phoneNumber;
		this.customerName = customerName;
		this.date = date;
		this.pdf = pdf;
		this.storeId = storeId;
	}

	public Bill(String phoneNumber, String customerName, Date date, float price, String pdf, long storeId,
			List<BillProducts> billProducts) {
		super();
		this.phoneNumber = phoneNumber;
		this.customerName = customerName;
		this.date = date;
		this.price = price;
		this.pdf = pdf;
		this.storeId = storeId;
		this.billProducts = billProducts;
	}

	public Bill(String phoneNumber, String customerName, Date date, float price, String pdf, long storeId, Store store,
			List<BillProducts> billProducts) {
		super();
		this.phoneNumber = phoneNumber;
		this.customerName = customerName;
		this.date = date;
		this.price = price;
		this.pdf = pdf;
		this.storeId = storeId;
		this.store = store;
		this.billProducts = billProducts;
	}
		
}