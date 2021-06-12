package com.ss.ucm.ms.loans.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity Class for user_loan table
 * 
 * 
 * @author Charvin Patel
 */



@Entity
@Table(	name = "user_loan")
public class UserLoan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2662132185650208599L;
    
    @Column(name = "balance")
	private BigDecimal balance;
    
    @Column(name = "start_date")
	private LocalDate date;

//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "loan_id", nullable = false)
//	private Loan loan;
//	
//    
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "users_id", nullable = false)
//    private User user;
    
    @Id
    private int loanId;
    
    private int usersId;
        

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public int getUserId() {
		return usersId;
	}

	public void setUserId(int usersId) {
		this.usersId = usersId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

//	public Loan getLoan() {
//		return loan;
//	}
//
//	public void setLoan(Loan loan) {
//		this.loan = loan;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
    
	
 

    
}
