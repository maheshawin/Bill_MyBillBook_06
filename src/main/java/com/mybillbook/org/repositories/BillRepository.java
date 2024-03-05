package com.mybillbook.org.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybillbook.org.entities.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>{
	
	List<Bill> findByStoreId(long storeId);
	
	List<Bill> findByPhoneNumber(String phoneNumber);
	
}