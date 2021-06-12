package com.ss.ucm.ms.loans.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.ucm.ms.loans.entities.UserLoan;

/**
 * Repository Class for Handling database calls
 * 
 * 
 * @author Charvin Patel
 */

	
	@Repository
	public interface UserLoanDAO extends JpaRepository<UserLoan, Integer> {
	    
	}



