package com.mybillbook.org.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybillbook.org.entities.Bill;
import com.mybillbook.org.exceptions.BillNotFoundException;
import com.mybillbook.org.exceptions.PhoneNumberNotFoundException;
import com.mybillbook.org.exceptions.StoreNotFoundException;
import com.mybillbook.org.repositories.BillRepository;
import com.mybillbook.org.services.BillService;

@Service
public class BillServiceImpl implements BillService{

	@Autowired
	BillRepository billRepository;
	
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
	public Bill getBillByBillId(long billId) throws BillNotFoundException {
		return billRepository.findById(billId).orElseThrow(()-> new BillNotFoundException("Bill ID not found Exception"));
	}

	@Override
	public List<Bill> getBillsByStoreId(long storeId) throws StoreNotFoundException {	
		return billRepository.findByStoreId(storeId);
	}

	@Override
	public List<Bill> getBillsByPhoneNumber(String phoneNumber) throws PhoneNumberNotFoundException {
		
		return billRepository.findByPhoneNumber(phoneNumber);
	}

}
