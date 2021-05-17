package com.ss.ucm.ms.loans.dao;

import com.ss.ucm.ms.loans.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface LoanDAO extends JpaRepository<Loan, Integer> {
    /**
     * Get the first 50 results, querying all data.
     * @return A collection of at most 50 Accounts.
     */
    Collection<Loan> findTop50ByOrderById();
}
