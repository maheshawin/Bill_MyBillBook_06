package com.mybillbook.org.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mybillbook.org.entities.BillProducts;
import com.mybillbook.org.exceptions.BillNotFoundException;
import com.mybillbook.org.exceptions.ProductsNotFoundException;
import com.mybillbook.org.repositories.BillProductRepository;
import com.mybillbook.org.services.BillProductService;
import com.mybillbook.org.vo.Product;

@Service
public class BillProductServiceImpl implements BillProductService {
	
	@Autowired
    private RestTemplate restTemplate;

	@Autowired
	 BillProductRepository billProductRepository;
	
	@Override
	public String createBillproduct(BillProducts billProducts) {
		
		billProductRepository.save(billProducts);
		return "BillProduct Saved";
	}

	@Override
	public String deleteBillProducts(BillProducts billProducts) {
		
		billProductRepository.deleteById(billProducts.getBillproductId());
		return "BillProduct Delete Successfully";
	}

	@Override
	public String updateBillProducts(BillProducts billProducts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BillProducts> getBillProductByBillId(long billId) throws ProductsNotFoundException, BillNotFoundException {
		List<BillProducts> billproducts = billProductRepository.findByBillId(billId);
		getProductsByBillId(billproducts);
		return billproducts;
	}

	@Override
	public List<BillProducts> getProductsByBillId(List<BillProducts> billproducts) throws BillNotFoundException {
		//log.info("Inside getUserWithDepartment of UserService");

		for(BillProducts billProduct: billproducts) {
        Product product =
                restTemplate.getForObject("http://localhost:9006/products/" + billProduct.getProductId()
                        ,Product.class);
        billProduct.setProduct(product);
		}
        return billproducts;
	}
}
