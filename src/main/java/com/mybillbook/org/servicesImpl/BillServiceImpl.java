package com.mybillbook.org.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mybillbook.org.entities.Bill;
import com.mybillbook.org.entities.BillProducts;
import com.mybillbook.org.exceptions.BillNotFoundException;
import com.mybillbook.org.exceptions.PhoneNumberNotFoundException;
import com.mybillbook.org.exceptions.ProductsNotFoundException;
import com.mybillbook.org.exceptions.StoreNotFoundException;
import com.mybillbook.org.repositories.BillRepository;
import com.mybillbook.org.services.BillProductService;
import com.mybillbook.org.services.BillService;
import com.mybillbook.org.vo.Product;
import com.mybillbook.org.vo.Store;

@Service
public class BillServiceImpl implements BillService{
	
	@Autowired
	BillProductService billProductService;

	@Autowired
	BillRepository billRepository;
	
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Override
	public String createBill(Bill bill) {
		billRepository.save(bill);
		return "Bill created successfully";
	}

	@Override
	public String deleteBill(long billId) {
		billRepository.deleteById(billId);
		return "Bill deleted successfully";
	}

	@Override
	public Bill getBillByBillId(long billId) throws BillNotFoundException, ProductsNotFoundException {
		Bill bill = billRepository.findById(billId).orElseThrow(()-> new BillNotFoundException("Bill ID not found Exception"));
		bill.setBillProducts(billProductService.getBillProductByBillId(billId));
		return bill;
	}

	@Override
	public List<Bill> getBillsByStoreId(long storeId) throws StoreNotFoundException {	
		return billRepository.findByStoreId(storeId);
	}

	@Override
	public List<Bill> getBillsByPhoneNumber(String phoneNumber) throws PhoneNumberNotFoundException, StoreNotFoundException, ProductsNotFoundException, BillNotFoundException {
		
		List <Bill> bills =billRepository.findByPhoneNumber(phoneNumber);
		bills=getStoreDetailsByStoreId(bills);
		for(Bill bill: bills) {
			
			List<BillProducts> billProducts =billProductService.getBillProductByBillId(bill.getBillId());
			bill.setBillProducts(billProducts);
		}
		return bills ;
	}

	@Override
	public List<Bill> getStoreDetailsByStoreId(List<Bill> bills) throws StoreNotFoundException {
		
		for(Bill bill: bills) {
	        Store store =
	                restTemplate.getForObject("http://localhost:9005/stores/s/" + bill.getStoreId()
	                        ,Store.class);
	        
	        System.out.println(store);
	        bill.setStore(store);
			}
		
		
	        return bills;
	}

	
	
}
