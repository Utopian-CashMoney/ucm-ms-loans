package com.ss.ucm.ms.loans.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.ucm.ms.loans.dao.LoanDAO;
import com.ss.ucm.ms.loans.dto.RequestLoanSignupDto;
import com.ss.ucm.ms.loans.entities.Loan;
import com.ss.ucm.ms.loans.entities.UserLoan;

/**
 * Service Class for calling loan repository
 * 
 * 
 * @author Charvin Patel
 */

@Service
@Transactional
public class LoanAdd {
	
	@Autowired
	private LoanSearch loanSearch;
	
	@Autowired
    private LoanDAO loanDAO;
	
    
    @Autowired
    UserLoanAdd userLoanAdd;
    
	/**
	 * 
	 * @param loan
	 * @return Loan(Entity)
	 * 
	 */
	
    public Loan saveLoan(Loan loan) {
    	return loanDAO.save(loan);
    }
    
    
      
	/**
	 * 
	 * @param userId, loanRequest(body)
	 * @return void
	 * 
	 */
    public void signUpLoan(int userId, RequestLoanSignupDto loanRequest) {
    	Loan loan = new Loan();
		
		loan.setMaxAmount(loanRequest.getMaxAmount());
		loan.setName(loanRequest.getName());
		loan.setInterestRate(loanRequest.getInterestRate());
				
		saveLoan(loan);

		UserLoan userLoan = new UserLoan();
		userLoan.setLoanId(loanSearch.LoanId(loanRequest.getName()));
		userLoan.setUserId(userId);
		userLoan.setBalance(loanRequest.getBalance());
		userLoan.setDate(loanRequest.getStartDate().now());
				
		userLoanAdd.saveUserLoan(userLoan);
    }
    
    
  
}
