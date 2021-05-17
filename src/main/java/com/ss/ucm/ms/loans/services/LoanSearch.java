package com.ss.ucm.ms.loans.services;

import com.ss.ucm.ms.loans.dao.LoanDAO;
import com.ss.ucm.ms.loans.entities.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

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
}
