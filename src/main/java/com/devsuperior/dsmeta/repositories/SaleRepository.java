package com.devsuperior.dsmeta.repositories;

<<<<<<< HEAD
=======
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
>>>>>>> f14aa381f862f3c50916331e856b8ba78a08767e
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
<<<<<<< HEAD
	
	
<<<<<<< HEAD
	@Query("SELECT obj "
			+ "FROM Sale obj "
			+ "WHERE obj.date BETWEEN :start AND :end AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))")
	Page<Sale> searchReportByDateAndName(String name, LocalDate start, LocalDate end, Pageable pageable);
=======

>>>>>>> parent of bb29e06 (Inicio do desafio)
=======
	@Query("SELECT obj, obj.seller.name "
			+ "FROM Sale obj "
			+ "WHERE obj.date BETWEEN :start AND :end AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))")
	Page<Sale> searchReport(String name, String start, String end, Pageable pageable);
	
	@Query("SELECT obj.date FROM Sale obj "
			+ "WHERE obj.date >= DATEADD('MONTH', -12, CURRENT_DATE)")
	Page<Sale> searchReport(Pageable pagealbe);
>>>>>>> f14aa381f862f3c50916331e856b8ba78a08767e
}
