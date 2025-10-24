package com.devsuperior.dsmeta.repositories;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
		
		@Query("SELECT new com.devsuperior.dsmeta.dto.SaleMinDTO(obj) "
				+ "FROM Sale obj "
				+ "WHERE obj.date BETWEEN :minDate AND :maxDate AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%')) "
				+ "ORDER BY obj.id ASC")
		Page<SaleMinDTO> searchByDateAndName(String name, LocalDate minDate, LocalDate maxDate, Pageable pageable);
	
		/*@Query(value = "SELECT obj FROM Sale obj JOIN FETCH obj.seller "
				+ "WHERE obj.date BETWEEN :minDate AND :maxDate AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))",
				countQuery = "SELECT COUNT(obj) FROM Sale obj JOIN obj.seller "
				+ "WHERE obj.date BETWEEN :minDate AND :maxDate AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))")   
	    Page<Sale> searchByDateAndName(String name, LocalDate minDate, LocalDate maxDate, Pageable pageable);*/
		
		@Query("SELECT obj FROM Sale obj "
				+"WHERE obj.date > :twelveMonth")
		Page<Sale> searchByLastTwelveMonths(LocalDate twelveMonth, Pageable pageable);
		
		@Query("SELECT new com.devsuperior.dsmeta.dto.SaleSummaryDTO(obj.seller.name, SUM(obj.amount)) FROM Sale obj "
				+ "WHERE obj.date BETWEEN :minDate AND :maxDate "
				+ "GROUP BY obj.seller.name")
		List<SaleSummaryDTO> searchByTotalSales(LocalDate minDate,LocalDate maxDate);
		
		@Query("SELECT new com.devsuperior.dsmeta.dto.SaleSummaryDTO(obj.seller.name, SUM(obj.amount)) FROM Sale obj "
				+ "WHERE obj.date > :twelveMonth "
				+ "GROUP BY obj.seller.name")
		List<SaleSummaryDTO> searchTotalSaleByLastTwelveMonths(LocalDate twelveMonth);
}
