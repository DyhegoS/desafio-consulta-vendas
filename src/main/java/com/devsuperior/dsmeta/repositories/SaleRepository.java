package com.devsuperior.dsmeta.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	
	@Query("SELECT obj, obj.seller.name "
			+ "FROM Sale obj "
			+ "WHERE obj.date BETWEEN :start AND :end AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))")
	Page<Sale> searchReport(String name, String start, String end, Pageable pageable);
	
	@Query("SELECT obj.date FROM Sale obj "
			+ "WHERE obj.date >= DATEADD('MONTH', -12, CURRENT_DATE)")
	Page<Sale> searchReport(Pageable pagealbe);
}
