package com.mybillbook.org.entities;

import java.util.Date;

import com.mybillbook.org.vo.Product;

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
@Table(name ="billproducts")
public class BillProducts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long BillproductId;
	private Long billId;
	private Long productId;
	private int quantity;
	
	@Transient
	private Product product;
}
