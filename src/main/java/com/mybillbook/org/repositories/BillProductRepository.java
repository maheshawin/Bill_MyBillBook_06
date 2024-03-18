package com.mybillbook.org.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.mybillbook.org.entities.BillProducts;
import java.util.List;


@Repository
public interface BillProductRepository extends JpaRepository<BillProducts, Long> {

	public List<BillProducts> findByBillId(Long billId);
	
}
