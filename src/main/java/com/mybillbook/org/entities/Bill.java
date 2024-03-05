package com.mybillbook.org.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	private String pdf;	
	private long storeId;
	public Bill(String phoneNumber, String customerName, Date date, String pdf, long storeId) {
		super();
		this.phoneNumber = phoneNumber;
		this.customerName = customerName;
		this.date = date;
		this.pdf = pdf;
		this.storeId = storeId;
	}
	
	
}