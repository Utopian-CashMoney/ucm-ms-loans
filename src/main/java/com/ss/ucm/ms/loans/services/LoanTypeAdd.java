package com.ss.ucm.ms.loans.services;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.ucm.ms.loans.dao.AccountTypeDAO;
import com.ss.ucm.ms.loans.dto.RequestAccountTypeDto;
import com.ss.ucm.ms.loans.dto.RequestUserAccountDto;
import com.ss.ucm.ms.loans.dto.RequestUserLoanSignupDto;
import com.ss.ucm.ms.loans.entities.AccountType;
import com.ss.ucm.ms.loans.entities.UserAccount;
import com.ss.ucm.ms.loans.entities.UserLoan;


/**
 * Service Class for calling loan repository
 * 
 * 
 * @author Charvin Patel
 */

@Service
@Transactional
public class LoanTypeAdd {

	@Autowired
	private LoanSearch loanSearch;

//	@Autowired
//	private LoanTypeDAO loanTypeDAO;


	@Autowired
	UserLoanAdd userLoanAdd;
	
	@Autowired
	AccountTypeDAO accountTypeDao;

	/**
	 * 
	 * @param loan
	 * @return Loan(Entity)
	 * 
	 */

//	public LoanType saveLoan(LoanType loantype) {
//		return loanTypeDAO.save(loantype);
//	}



	/**
	 * 
	 * @param userId, loanRequest(body)
	 * @return void
	 * 
	 */
	public void signUpLoan(BigDecimal balance, RequestUserLoanSignupDto loanTypeRequest) {

		UserLoan userLoan = new UserLoan();
		UserAccount userAccount = new UserAccount();
		
//		userLoan.setLoanTypeId(loanSearch.LoanId(loanTypeRequest.getName()));
//		userLoan.setUserAccount_accountNumber(userAccount_accountNumber);
//		userLoan.setSalary(loanTypeRequest.getSalary());
//		userAccount.setBalance(balance);
//		userLoan.setDate(loanTypeRequest.getStartDate().now());
//		userLoan.setIs_accepted(true);
//
//		userLoanAdd.saveUserLoan(userLoan);
		
//		userLoan.setUserAccount_accountNumber(loanTypeRequest.getUser_account_account_number());
//		userLoan.setSalary(loanTypeRequest.getSalary());
//		userAccount.setBalance(balance);
//		userLoan.setDate(loanTypeRequest.getStartDate().now());
//		userLoan.setIs_accepted(true);
		
//		System.out.println("Values here........" + loanTypeRequest.getUser_account_account_number() + loanTypeRequest.getSalary() + loanTypeRequest.getStartDate().now() + true + loanTypeRequest.getTerm());

		userLoanAdd.saveUserLoan(loanTypeRequest.getUser_account_account_number(), loanTypeRequest.getSalary(), loanTypeRequest.getStart_date().now(), true, loanTypeRequest.getTerm());
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
	
	
	public void createLoan(RequestAccountTypeDto accountTypeDto) {
		AccountType accountType = new AccountType();
		
//		accountType.setMaxAmount(accountTypeDto.getMax_amount());
//		accountType.setName(accountTypeDto.getName());
//		accountType.setInterestRate(accountTypeDto.getInterest_rate());
//		accountType.setTerm(accountTypeDto.getTerm());
		
//		System.out.println("Name: " + accountTypeDto.getName() + " Type: " + accountTypeDto.getType() + " AllowCredit: " + accountTypeDto.getAllowCredit() + " Credit Limit: " + accountTypeDto.getCreditLimit() + " AllowCard: " + accountTypeDto.getAllowCards() + " Apr: " + accountTypeDto.getApr() + " Perks: " +  accountTypeDto.getPerks());
		
		accountType.setName(accountTypeDto.getName());
		accountType.setType("LOAN");
		accountType.setAllow_credit(true);
//		accountType.setCreditLimit(accountTypeDto.getCreditLimit());
		accountType.setCredit_limit(accountTypeDto.getCredit_limit());
		accountType.setAllow_cards(true);
		accountType.setApr(accountTypeDto.getApr());
		accountType.setPerks(accountTypeDto.getPerks());
		
		System.out.println("Name: " + accountTypeDto.getName() + " Type: " + accountType.getType() + " AllowCredit: " + accountType.isAllow_credit() + " Credit Limit: " + accountTypeDto.getCredit_limit() + " AllowCard: " + accountType.isAllow_cards() + " Apr: " + accountTypeDto.getApr() + " Perks: " +  accountTypeDto.getPerks());
		
		
		accountTypeDao.save(accountType);
	}



}
