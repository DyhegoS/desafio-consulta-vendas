package com.devsuperior.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
<<<<<<< HEAD
	
	
	@Query("SELECT obj "
			+ "FROM Sale obj "
			+ "WHERE obj.date BETWEEN :start AND :end AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))")
	Page<Sale> searchReportByDateAndName(String name, LocalDate start, LocalDate end, Pageable pageable);
=======

>>>>>>> parent of bb29e06 (Inicio do desafio)
}
