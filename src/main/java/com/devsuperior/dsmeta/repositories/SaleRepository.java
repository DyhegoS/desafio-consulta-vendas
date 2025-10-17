package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	
	@Query("SELECT obj.id, obj.amount, obj.date, obj.seller.name "
			+ "FROM Sale obj "
			+ "WHERE obj.date BETWEEN :start AND :end AND UPPER(obj.seller.name) LIKE UPPER('%', :name, '%')")
	Page<Sale> searchReport(String name, LocalDate start, LocalDate end, Pageable pageable);
}
