package com.ss.ucm.ms.loans.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Entity Class for user_loan table
 * 
 * 
 * @author Charvin Patel
 */


@Entity
@Table(	name = "user_loan")
//@IdClass(LoanTypeIdUserId.class)
public class UserLoan implements Serializable {

	private static final long serialVersionUID = -2662132185650208599L;
	
    @Column(name = "salary")
	private int salary;
    
//    @Column(name = "balance")
//	private BigDecimal balance;
//    
    @Column(name = "start_date")
	private LocalDate date;
    
    @Column(name = "is_accepted")
	private Boolean is_accepted;
     
//    @Id
//    private int loanTypeId;
    
    @Id
    private String userAccount_accountNumber;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

//	public BigDecimal getBalance() {
//		return balance;
//	}
//
//	public void setBalance(BigDecimal balance) {
//		this.balance = balance;
//	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Boolean getIs_accepted() {
		return is_accepted;
	}

	public void setIs_accepted(Boolean is_accepted) {
		this.is_accepted = is_accepted;
	}

//	public int getLoanTypeId() {
//		return loanTypeId;
//	}
//
//	public void setLoanTypeId(int loanTypeId) {
//		this.loanTypeId = loanTypeId;
//	}

	public String getUserAccount_accountNumber() {
		return userAccount_accountNumber;
	}

	public void setUserAccount_accountNumber(String userAccount_accountNumber) {
		this.userAccount_accountNumber = userAccount_accountNumber;
	}

    
    
}
