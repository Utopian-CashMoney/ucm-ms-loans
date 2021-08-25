package com.ss.ucm.ms.loans.controllers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.ss.ucm.ms.loans.dao.UserAccountDAO;
import com.ss.ucm.ms.loans.dao.UserDAO;
import com.ss.ucm.ms.loans.dao.UserLoanDAO;
import com.ss.ucm.ms.loans.dto.RequestAccountTypeDto;
import com.ss.ucm.ms.loans.dto.RequestUserAccountDto;
import com.ss.ucm.ms.loans.dto.RequestUserLoanSignupDto;
import com.ss.ucm.ms.loans.dto.ResponseLoanMonthlyPaymentDto;
import com.ss.ucm.ms.loans.entities.AccountType;
import com.ss.ucm.ms.loans.entities.UserAccount;
import com.ss.ucm.ms.loans.services.LoanSearch;
import com.ss.ucm.ms.loans.services.LoanTypeAdd;
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
	LoanTypeAdd loanTypeAdd;

//	@Autowired
//	LoanTypeDAO loanTypeDao;

	@Autowired
	UserLoanAdd userLoanAdd;

	@Autowired
	UserDAO userDao;
	
	@Autowired
	UserLoanDAO UserLoanDAO;
	
	@Autowired
	UserAccountDAO userAccountDAO;
	
	
	RequestUserAccountDto userAccountDto;
	

	@Autowired
	private SpringTemplateEngine templateEngine;

	@Autowired
	public LoansController(LoanSearch loanSearch) {
		this.loanSearch = loanSearch;
	}

	/**
	 * GET /api/loans - Return all loans
	 * 
	 * @return All loans on offer
	 */
	
	
	// WORKINGGG
	@GetMapping("/all_loans")
	public ResponseEntity<Collection<AccountType>> get(@RequestParam String type) {
		try {
			Collection<AccountType> loans = loanSearch.getLoans(type);
			return new ResponseEntity<>(loans, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 
	 * @param salary(user), amount of loan, loan Term, loan interest rate.
	 * @return ResponseEntity
	 * 
	 */

	
	// WORKINGGGGGGGGGG
	
	@PostMapping("/loansignup")
	public ResponseEntity<?> signupLoan(@RequestParam int salary, @RequestParam int amount, @RequestParam int term,
			@RequestParam double interestRate) {

		DecimalFormat df = new DecimalFormat("###.##");

		int termInMonths = term * 12;

		ResponseLoanMonthlyPaymentDto loanDto = new ResponseLoanMonthlyPaymentDto();

		double monthlyPayments = loanTypeAdd.calculateMonthlyPayments(amount, term, interestRate);

		double totalPayments = loanTypeAdd.calculateTotalPayment(monthlyPayments, termInMonths);

		// loanDto.setPayments(monthlyPayments);
		loanDto.setPayments(Double.valueOf(df.format((monthlyPayments))));
		loanDto.setTotalPayment(Double.valueOf(df.format((totalPayments))));

		return ResponseEntity.ok((new ResponseLoanMonthlyPaymentDto(loanDto.getPayments(), loanDto.getTotalPayment())));

	}

	/**
	 * 
	 * @param user id, loanrequest
	 * @return void
	 * 
	 */
	
	
	
	// WORKINGGGGGG
	

	@PostMapping("/loanSignupSuccess")
	public void signupLoanSuccess(@RequestParam BigDecimal balance,  @RequestBody RequestUserLoanSignupDto loanRequest) {

		// Before setting is_accpeted to true/loan accepeted... we need to
		// make sure that our customer makes atleast 50% of what their loan amount is.
		//double acceptableIncome = loanRequest.getBalance().doubleValue() * 0.50;
		
		double acceptableIncome = balance.doubleValue() * 0.50;


				
		
//		User toEmail = userDao.getEmailById(userAccount_accountNumber);
		UserAccount userID = userAccountDAO.getUserIDByaccountNumber(loanRequest.getUser_account_account_number());

		System.out.println("HEREEE ID" + userID.getUser().getId());
		String to = userID.getUser().getEmail();
		
//		String to = userID.getEmail();
		String from = "utopiacashmoney99@gmail.com";
		final String username = "utopiacashmoney99@gmail.com";
		final String password = "UtopiaBanking100?";

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message message = new MimeMessage(session);

		if (loanRequest.getSalary() >= acceptableIncome) {

			loanTypeAdd.signUpLoan(balance, loanRequest);

			try {
				message.setFrom(new InternetAddress(from));

				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

				Context context = new Context();
				String html = templateEngine.process("../templates/loanAccepted.html", context);

				message.setSubject("Loan Application Update!");
				message.setContent(html, "text/html");

				Transport.send(message);
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}

		} else {
			try {
				message.setFrom(new InternetAddress(from));

				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

				Context context = new Context();

				String html = templateEngine.process("../templates/loanRejected.html", context);

				message.setSubject("Loan Application Update!");
				message.setContent(html, "text/html");
				Transport.send(message);
			} catch (Exception e) {

			}

		}

	}
	
	
	/**
	 * 
	 * @param RequestCreateLoanDto
	 * @return void
	 * 
	 */

	
	
	
	
	// WORKINGGGGGGGGGGGGGGG
	
	@PostMapping("/createLoans")
	public void createLoans(@RequestBody RequestAccountTypeDto accountTypeDto) {

		loanTypeAdd.createLoan(accountTypeDto);

	}

}
