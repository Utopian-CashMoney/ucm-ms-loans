package com.ss.ucm.ms.loans.dao;

import com.ss.ucm.ms.loans.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Repository for Loan Class for Handling database Calls
 * 
 * 
 * @author Charvin Patel
 */


@Repository
public interface LoanDAO extends JpaRepository<Loan, Integer> {
    /**
     * Get the first 50 results, querying all data.
     * @return A collection of at most 50 Accounts.
     */
    Collection<Loan> findTop50ByOrderById();
    
    
	/**
	 * 
	 * @param name
	 * @return user_id(int)
	 * 
	 */
    
    @Query("SELECT id FROM Loan where name = :name") 
    public int getIdByName(String name);
    
}
