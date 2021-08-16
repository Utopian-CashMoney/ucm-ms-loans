package com.ss.ucm.ms.loans.services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.ucm.ms.loans.dao.AccountTypeDAO;
import com.ss.ucm.ms.loans.entities.AccountType;

@Service
@Transactional
public class LoanSearch {
//    private final LoanTypeDAO loanTypeDAO;
	
    private final AccountTypeDAO accountTypeDao;
    
    @Autowired
    public LoanSearch(AccountTypeDAO accountTypeDao) {
        this.accountTypeDao = accountTypeDao;
    }

    public Collection<AccountType> getLoans(String type) {
    	
        return accountTypeDao.getLoans(type);
    }
    
    
	/**
	 * 
	 * @param name
	 * @return user_id(int)
	 * 
	 */
//    public int LoanId(String name) {
//    	 return loanTypeDAO.getIdByName(name);
//    }
    
}
