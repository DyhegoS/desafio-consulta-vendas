package com.devsuperior.dsmeta.repositories;


import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
		@Query("SELECT obj FROM Sale obj "
				+ "WHERE obj.date BETWEEN :minDate AND :maxDate AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))")   
	    Page<Sale> searchByDateAndName(String name, LocalDate minDate, LocalDate maxDate, Pageable pageable);
		
		@Query("SELECT obj FROM Sale obj "
				+"WHERE obj.date > :twelveMonth")
		Page<Sale> searchByLastTwelveMounths(LocalDate twelveMonth, Pageable pageable);
}
