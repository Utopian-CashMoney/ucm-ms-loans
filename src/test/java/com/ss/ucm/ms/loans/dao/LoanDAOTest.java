package com.ss.ucm.ms.loans.dao;

import com.ss.ucm.ms.loans.entities.Loan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class LoanDAOTest {
    @Autowired
    private LoanDAO loanDAO;

    /**
     * @author Joshua Podhola
     */
    @Test
    void findTop50ByOrderByIdTest() {
        //Add more than 50 tests. Probably not efficient, but that's really not what I'm concerned about.
        for(int i = 0; i != 60; i++) {
            Loan account = new Loan(BigDecimal.valueOf(100), "LoanSomething", BigDecimal.valueOf(100));
            loanDAO.save(account);
        }
        Collection<Loan> loans = loanDAO.findTop50ByOrderById();
        assertEquals(50, loans.size());
    }
}