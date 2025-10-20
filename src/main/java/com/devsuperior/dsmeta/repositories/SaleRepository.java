package com.devsuperior.dsmeta.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
		@Query(value = "SELECT obj FROM Sale obj JOIN FETCH obj.seller "
				+ "WHERE UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))",
	        countQuery = "SELECT COUNT(obj.seller.name) FROM Sale obj JOIN obj.seller " 
	    	        + "WHERE UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))")
	    Page<Sale> searchByName(String name, Pageable pageable);
}
