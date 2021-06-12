package com.ss.ucm.ms.loans.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ss.ucm.ms.loans.dto.RequestLoanSignupDto;
import com.ss.ucm.ms.loans.entities.Loan;
import com.ss.ucm.ms.loans.entities.UserLoan;
import com.ss.ucm.ms.loans.services.LoanAdd;
import com.ss.ucm.ms.loans.services.LoanSearch;
import com.ss.ucm.ms.loans.services.UserLoanAdd;


/**
 * Controller Class for Handling API calls
 * 
 * 
 * @author Charvin Patel
 */


@RestController
@RequestMapping("/loans")
@CrossOrigin

public class LoansController {
    private final LoanSearch loanSearch;
    
    @Autowired
    LoanAdd loanAdd;
    
    @Autowired
    UserLoanAdd userLoanAdd;
    
    
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
    
    
	/**
	 * 
	 * @param userId, loanRequest(body)
	 * @return void
	 * 
	 */
    
    
	@PostMapping("/loansignup")
	public void signupLoan(@RequestParam int userId,  @RequestBody RequestLoanSignupDto loanRequest) {
			
		Loan loan = new Loan();
		
		loan.setMaxAmount(loanRequest.getMaxAmount());
		loan.setName(loanRequest.getName());
		loan.setInterestRate(loanRequest.getInterestRate());
				
		loanAdd.saveLoan(loan);

		UserLoan userLoan = new UserLoan();
		userLoan.setLoanId(loanSearch.LoanId(loanRequest.getName()));
		userLoan.setUserId(userId);
		userLoan.setBalance(loanRequest.getBalance());
		userLoan.setDate(loanRequest.getStartDate().now());
				
		userLoanAdd.saveUserLoan(userLoan);
		
		
	}
}
