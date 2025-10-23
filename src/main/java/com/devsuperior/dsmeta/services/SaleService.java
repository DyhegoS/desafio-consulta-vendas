package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	
	public Page<SaleMinDTO> findAll(String name, String minDate, String maxDate, Pageable pageable) {
	    LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

	    LocalDate startDate;
	    LocalDate endDate;
	    
	    if ((name == null || name.isBlank()) && (minDate == null || minDate.isBlank()) && (maxDate == null || maxDate.isBlank())) {
	        LocalDate twelveMonthsAgo = today.minusMonths(12);
	        Page<Sale> result = repository.searchByLastTwelveMounths(twelveMonthsAgo, pageable);
	        return result.map(x -> new SaleMinDTO(x));
	    }

	    if (minDate == null || minDate.isBlank()) {
	        startDate = today.minusYears(1L);
	    }else {
	    	startDate  = LocalDate.parse(minDate);
	    }

	    if (maxDate == null || maxDate.isBlank()) {
	        endDate = today;
	    }else {
	    	endDate = LocalDate.parse(maxDate);
	    }
	    
	    Page<Sale> result = repository.searchByDateAndName(name, startDate, endDate, pageable);
	    return result.map(x -> new SaleMinDTO(x));
	}

}
