package com.ss.ucm.ms.loans.services;

import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.ucm.ms.loans.dao.LoanDAO;
import com.ss.ucm.ms.loans.entities.Loan;

@Service
@Transactional
public class LoanSearch {
    private final LoanDAO loanDAO;
    
    @Autowired
    public LoanSearch(LoanDAO loanDAO) {
        this.loanDAO = loanDAO;
    }

    public Collection<Loan> getFirst50() {
        return loanDAO.findTop50ByOrderById();
    }
    
    
	/**
	 * 
	 * @param name
	 * @return user_id(int)
	 * 
	 */
    public int LoanId(String name) {
    	 return loanDAO.getIdByName(name);
    }
    
}
