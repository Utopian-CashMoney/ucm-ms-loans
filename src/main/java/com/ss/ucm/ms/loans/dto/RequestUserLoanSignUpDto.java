package com.ss.ucm.ms.loans.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotBlank;

/**
 * RequestUserLoanSignUpDto class needed to hold the user loan signup details
 * the user clicks via loan signup page which then gets added into
 * the database
 * 
 * @author Charvin Patel
 */

public class RequestUserLoanSignUpDto {

	@NotBlank
	private BigDecimal balance;
	
	@NotBlank
	private LocalDate startDate;

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	
	
}
