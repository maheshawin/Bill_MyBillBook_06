package com.mybillbook.org.services;


import java.util.List;

import com.mybillbook.org.entities.Bill;
import com.mybillbook.org.entities.BillProducts;
import com.mybillbook.org.exceptions.BillNotFoundException;
import com.mybillbook.org.exceptions.ProductsNotFoundException;
import com.mybillbook.org.exceptions.StoreNotFoundException;
import com.mybillbook.org.vo.Product;

public interface BillProductService {

	String createBillproduct(BillProducts billProducts);
	String deleteBillProducts(BillProducts billProducts);
	String updateBillProducts(BillProducts billProducts);
	
	List<BillProducts> getBillProductByBillId(long billId) throws ProductsNotFoundException,BillNotFoundException;
	
	List<BillProducts> getProductsByBillId(List<BillProducts> billproducts) throws BillNotFoundException;
	
	
}
