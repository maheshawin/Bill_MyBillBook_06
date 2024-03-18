package com.mybillbook.org.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybillbook.org.entities.Bill;
import com.mybillbook.org.entities.BillProducts;
import com.mybillbook.org.exceptions.BillNotFoundException;
import com.mybillbook.org.exceptions.ProductsNotFoundException;
import com.mybillbook.org.exceptions.StoreNotFoundException;
import com.mybillbook.org.services.BillProductService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = {"${app.security.cors.origin}"})
@RestController
@RequestMapping("/billProducts")
@Slf4j
@Tag(name ="Bill - Products- Management Service", description = "Bills Info")
public class BillProductController {

	@Autowired
	BillProductService billProductService;
	
	
	@PostMapping("/save")
	public String saveBillProducts(@RequestBody BillProducts billProducts) {
		log.info("inside saveBillProducts");
		return billProductService.createBillproduct(billProducts);
	}
	
	@PostMapping("/delete")
	public String deleteBillProduct(@RequestBody BillProducts billProducts) {
		log.info("inside deleteBillproduct");
		return billProductService.deleteBillProducts(billProducts);
	}
	
	@GetMapping("/bill/{billId}")
	public List<BillProducts> getBillProductByBillId(@PathVariable("billId") Long billId) throws ProductsNotFoundException, BillNotFoundException {
		log.info("inside getBillProductByBillId" + billId);
		return billProductService.getBillProductByBillId(billId);
	}
	
	
}
