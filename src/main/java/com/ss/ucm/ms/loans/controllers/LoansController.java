package com.ss.ucm.ms.loans.controllers;

import com.ss.ucm.ms.loans.entities.Loan;
import com.ss.ucm.ms.loans.services.LoanSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/loans")
@CrossOrigin
public class LoansController {
    private final LoanSearch loanSearch;

    @Autowired
    public LoansController(LoanSearch loanSearch) {
        this.loanSearch = loanSearch;
    }

    /**
     * GET /api/loans - Return all loans
     * @return First 50 loans
     */
    @GetMapping
    public ResponseEntity<Collection<Loan>> get() {
        try {
            Collection<Loan> loans = loanSearch.getFirst50();
            return new ResponseEntity<>(loans, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
