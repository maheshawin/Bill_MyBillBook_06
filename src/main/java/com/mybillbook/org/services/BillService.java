package com.mybillbook.org.services;

import java.util.List;

import com.mybillbook.org.entities.Bill;
import com.mybillbook.org.exceptions.BillNotFoundException;
import com.mybillbook.org.exceptions.PhoneNumberNotFoundException;
import com.mybillbook.org.exceptions.StoreNotFoundException;

public interface BillService {

	String createBill(Bill bill);
	
	String deleteBill(long billId);
	
	Bill getBillByBillId(long billId) throws BillNotFoundException;
	
	List<Bill> getBillsByStoreId(long storeId) throws StoreNotFoundException;
	
	List<Bill> getBillsByPhoneNumber(String phoneNumber) throws PhoneNumberNotFoundException;
	
}
