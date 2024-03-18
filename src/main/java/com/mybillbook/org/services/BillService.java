package com.mybillbook.org.services;

import java.util.List;

import com.mybillbook.org.entities.Bill;
import com.mybillbook.org.exceptions.BillNotFoundException;
import com.mybillbook.org.exceptions.PhoneNumberNotFoundException;
import com.mybillbook.org.exceptions.ProductsNotFoundException;
import com.mybillbook.org.exceptions.StoreNotFoundException;
import com.mybillbook.org.vo.Store;

public interface BillService {

	String createBill(Bill bill);
	
	String deleteBill(long billId);
	
	Bill getBillByBillId(long billId) throws BillNotFoundException ,ProductsNotFoundException;
	
	List<Bill> getBillsByStoreId(long storeId) throws StoreNotFoundException;
	
	List<Bill> getBillsByPhoneNumber(String phoneNumber) throws PhoneNumberNotFoundException ,StoreNotFoundException,ProductsNotFoundException,BillNotFoundException;
	
	List<Bill>  getStoreDetailsByStoreId(List<Bill> bills)throws StoreNotFoundException ;
	
}
