package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
<<<<<<< HEAD
	public ResponseEntity<?> getReport() {
		// TODO
		return null;
=======
	public ResponseEntity<Page<SaleMinDTO>> getReport(@RequestParam(defaultValue = "") String name, 
													@RequestParam(name = "minDate", defaultValue = "")String start, 
													@RequestParam(name = "maxDate", defaultValue = "")String end, Pageable pageable) {
		Page<SaleMinDTO> dto = service.findAll(name, start, end, pageable);
		return ResponseEntity.ok(dto);
>>>>>>> f14aa381f862f3c50916331e856b8ba78a08767e
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<?> getSummary() {
		// TODO
		return null;
	}
}
