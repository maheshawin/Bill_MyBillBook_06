package com.mybillbook.org.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybillbook.org.entities.Bill;
import com.mybillbook.org.exceptions.BillNotFoundException;
import com.mybillbook.org.exceptions.PhoneNumberNotFoundException;
import com.mybillbook.org.exceptions.StoreNotFoundException;
import com.mybillbook.org.services.BillService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/bills")
@Slf4j
@Tag(name ="Bills Management Service", description = "Bills Info")
public class BillController {
	
	@Autowired
	BillService billService;
	
	
	@PostMapping("/save")
	public String savebill(@RequestBody Bill bill) {
		log.info("inside saveBill");
		return billService.createBill(bill);
	}
	
	@PostMapping("/delete")
	public String deleteBill(@RequestBody Long billId) {
		log.info("inside deleteBill");
		return billService.deleteBill(billId);
	}
	
	@GetMapping("/{id}")
	public Bill getBillByBillId(@PathVariable("id") Long billId) throws BillNotFoundException {
		log.info("inside getBillByBillId " + billId);
		return billService.getBillByBillId(billId);
	}
	
	@GetMapping("/store/{storeId}")
	public List<Bill> getBillsByStoreId(@PathVariable("storeId") Long storeId) throws StoreNotFoundException {
		log.info("inside getBillsByStoreId" + storeId);
		return billService.getBillsByStoreId(storeId);
	}

	@GetMapping("/user/{phoneNumber}")
	public List<Bill> getBillsByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) throws PhoneNumberNotFoundException {
		log.info("inside getBillsByStoreId" + phoneNumber);
		return billService.getBillsByPhoneNumber(phoneNumber);
	}

}