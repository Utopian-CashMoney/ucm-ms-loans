package com.ss.ucm.ms.loans.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * Repository for Loan Class for Handling database Calls
 * 
 * 
 * @author Charvin Patel
 */


//@Repository
//public interface LoanTypeDAO extends JpaRepository<LoanType, Integer> {
//    /**
//     * Get the first 50 results, querying all data.
//     * @return A collection of at most 50 Accounts.
//     */
//    Collection<LoanType> findTop50ByOrderById();
//    
//    
//	/**
//	 * 
//	 * @param name
//	 * @return user_id(int)
//	 * 
//	 */
//    
//    @Query("SELECT id FROM LoanType where name = :name") 
//    public int getIdByName(String name);
//    
//}
