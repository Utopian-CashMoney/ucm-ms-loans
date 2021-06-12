package com.ss.ucm.ms.loans.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

/**
 * RequestSignupDto class needed to hold the user signup details
 * the user enters via signup page which then gets added into
 * the database
 * 
 * @author Charvin Patel
 */


public class RequestLoanSignupDto {

	@NotBlank
	private int id;

	@NotBlank
	private BigDecimal max_amount;

	@NotBlank
	private String name;

	@NotBlank
	private BigDecimal interest_rate;

	@NotBlank
	private BigDecimal balance;

	@NotBlank
	private LocalDate startDate;


	RequestLoanSignupDto(BigDecimal max_amount, String name, BigDecimal interest_rate){
		this.max_amount = max_amount;
		this.name = name;
		this.interest_rate = interest_rate;
	}


	public BigDecimal getMaxAmount() {
		return max_amount;
	}

	public void setMaxAmount(BigDecimal max_amount) {
		this.max_amount = max_amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getInterestRate() {
		return interest_rate;
	}

	public void setInterestRate(BigDecimal interest_rate) {
		this.interest_rate = interest_rate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

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


