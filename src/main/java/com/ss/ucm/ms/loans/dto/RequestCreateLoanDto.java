package com.ss.ucm.ms.loans.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

public class RequestCreateLoanDto {
	
	@NotBlank
	private BigDecimal max_amount;

	@NotBlank
	private String name;

	@NotBlank
	private BigDecimal interest_rate;
	
	public RequestCreateLoanDto() {}


	public BigDecimal getMax_amount() {
		return max_amount;
	}

	public void setMax_amount(BigDecimal max_amount) {
		this.max_amount = max_amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(BigDecimal interest_rate) {
		this.interest_rate = interest_rate;
	};
	
	
	
	

}
