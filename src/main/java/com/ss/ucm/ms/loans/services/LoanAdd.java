package com.ss.ucm.ms.loans.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.ucm.ms.loans.dao.LoanDAO;
import com.ss.ucm.ms.loans.entities.Loan;

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
    private LoanDAO loanDAO;
    
	/**
	 * 
	 * @param loan
	 * @return Loan(Entity)
	 * 
	 */
	
    public Loan saveLoan(Loan loan) {
    	return loanDAO.save(loan);
    }
  
}
