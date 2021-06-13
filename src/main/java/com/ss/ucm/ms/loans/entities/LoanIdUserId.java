package com.ss.ucm.ms.loans.entities;
import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Class for composite key
 * 
 * 
 * @author Charvin Patel
 */

public class LoanIdUserId implements Serializable {

	private static final long serialVersionUID = 5129459523588005041L;
	
	private int loanId;
	
	private int usersId;
	
	public LoanIdUserId() {}
	
	public LoanIdUserId(int loanId, int usersId) {
		this.loanId = loanId;
		this.usersId = usersId;
	}
	
	
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
	
	

}
