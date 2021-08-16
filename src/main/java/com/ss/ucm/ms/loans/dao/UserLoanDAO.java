package com.ss.ucm.ms.loans.dao;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
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
	    
		@Modifying
		@Query(value = "insert into user_loan (user_account_account_number, salary, start_date, is_accepted, term) VALUES (:user_account_account_number, :salary, :start_date, :is_accepted, :term)", nativeQuery = true)
		@Transactional
		public void signupUserLoan( @Param("user_account_account_number") String user_account_account_number, @Param("salary") int salary, @Param("start_date") LocalDate start_date, @Param("is_accepted") Boolean is_accepted, @Param("term") String term);
		
		
	}



