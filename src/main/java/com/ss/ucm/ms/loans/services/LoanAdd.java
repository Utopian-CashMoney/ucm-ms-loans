package com.ss.ucm.ms.loans.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.ss.ucm.ms.loans.dao.LoanDAO;
import com.ss.ucm.ms.loans.dto.RequestCreateLoanDto;
import com.ss.ucm.ms.loans.dto.RequestLoanSignupDto;
import com.ss.ucm.ms.loans.entities.Loan;
import com.ss.ucm.ms.loans.entities.UserLoan;


/**
 * Service Class for calling loan repository
 * 
 * 
 * @author Charvin Patel
 */

@Service
@Transactional
public class LoanAdd {

	@Autowired
	private LoanSearch loanSearch;

	@Autowired
	private LoanDAO loanDAO;


	@Autowired
	UserLoanAdd userLoanAdd;

	/**
	 * 
	 * @param loan
	 * @return Loan(Entity)
	 * 
	 */

	public Loan saveLoan(Loan loan) {
		return loanDAO.save(loan);
	}



	/**
	 * 
	 * @param userId, loanRequest(body)
	 * @return void
	 * 
	 */
	public void signUpLoan(int userId, RequestLoanSignupDto loanRequest) {

		UserLoan userLoan = new UserLoan();
		userLoan.setLoanId(loanSearch.LoanId(loanRequest.getName()));
		userLoan.setUserId(userId);
		userLoan.setSalary(loanRequest.getSalary());
		userLoan.setBalance(loanRequest.getBalance());
		userLoan.setDate(loanRequest.getStartDate().now());
		userLoan.setIs_accepted(true);

		userLoanAdd.saveUserLoan(userLoan);
	}



	/**
	 * 
	 * @param amount of the loan, term of the loan, interest rate of the loan
	 * @return double
	 * 
	 * */

	public double calculateMonthlyPayments(int amount, int term, double interestRate) {

		interestRate /= 100.0;

		double monthlyRate = interestRate / 12.0;


		int termInMonths = term * 12;

		double monthlyPayment = 
				(amount*monthlyRate) / 
				(1-Math.pow(1+monthlyRate, -termInMonths));


		return monthlyPayment;
	}

	
	/**
	 * 
	 * @param monthly Payments, term in months
	 * @return double
	 * 
	 */
	
	public double calculateTotalPayment(double monthlyPayment, int termInMonths) {

		double totalPayment = monthlyPayment * termInMonths;
		System.out.println("Total Amount to be paid: " + totalPayment);


		return totalPayment;
	}
	
	
	public void createLoan(RequestCreateLoanDto createLoan) {
		Loan loan = new Loan();
		
		loan.setMaxAmount(createLoan.getMax_amount());
		loan.setName(createLoan.getName());
		loan.setInterestRate(createLoan.getInterest_rate());
		
		loanDAO.save(loan);
	}



}
