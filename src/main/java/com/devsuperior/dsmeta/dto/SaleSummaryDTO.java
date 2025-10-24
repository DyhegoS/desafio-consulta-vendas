package com.devsuperior.dsmeta.dto;

public class SaleSummaryDTO {
	private String sellerName;
	private Double amout;
	
	public SaleSummaryDTO(String sellerName, Double amout) {
		this.sellerName = sellerName;
		this.amout = amout;
	}

	public String getSellerName() {
		return sellerName;
	}

	public Double getAmout() {
		return amout;
	}
	
	
	
	
}
