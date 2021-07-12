package com.ss.ucm.ms.loans.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.ucm.ms.loans.dao.UserLoanDAO;
import com.ss.ucm.ms.loans.entities.UserLoan;

/**
 * Service Class for calling user_loan repository
 * 
 * 
 * @author Charvin Patel
 */

@Service
@Transactional
public class UserLoanAdd {

	@Autowired
	private UserLoanDAO userLoanDAO;

	
	/**
	 * 
	 * @param userLoan
	 * @return UserLoan(Entity)
	 * 
	 */
	public UserLoan saveUserLoan(UserLoan userLoan) {
		return userLoanDAO.save(userLoan);
	}

}
