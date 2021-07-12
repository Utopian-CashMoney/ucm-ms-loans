package com.ss.ucm.ms.loans.controllers;

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

import com.ss.ucm.ms.loans.dao.UserDAO;
import com.ss.ucm.ms.loans.dto.RequestLoanSignupDto;
import com.ss.ucm.ms.loans.dto.ResponseLoanMonthlyPaymentDto;
import com.ss.ucm.ms.loans.entities.Loan;
import com.ss.ucm.ms.loans.entities.User;
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
	UserDAO userDao;

	@Autowired
	private SpringTemplateEngine templateEngine;


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
	 * @param salary(user), amount of loan, loan Term, loan interest rate.
	 * @return ResponseEntity
	 * 
	 */
	
	@PostMapping("/loansignup")
	public ResponseEntity<?>signupLoan(@RequestParam int salary, @RequestParam int amount, @RequestParam int term, @RequestParam double interestRate) {

		DecimalFormat df = new DecimalFormat("###.##");
		
		int termInMonths = term * 12;

		ResponseLoanMonthlyPaymentDto loanDto = new ResponseLoanMonthlyPaymentDto();


		double monthlyPayments = loanAdd.calculateMonthlyPayments(amount, term, interestRate);

		double totalPayments = loanAdd.calculateTotalPayment(monthlyPayments, termInMonths);

		//loanDto.setPayments(monthlyPayments);
		loanDto.setPayments(Double.valueOf(df.format((monthlyPayments))));
		loanDto.setTotalPayment(Double.valueOf(df.format((totalPayments))));

		return  ResponseEntity.ok((new ResponseLoanMonthlyPaymentDto(loanDto.getPayments(), 
				loanDto.getTotalPayment())));

	}

	
	
	/**
	 * 
	 * @param user id, loanrequest
	 * @return void
	 * 
	 */

	@PostMapping("/loanSignupSuccess")
	public void signupLoanSuccess(@RequestParam int userId,  @RequestBody RequestLoanSignupDto loanRequest) {

		//Before setting is_accpeted to true/loan accepeted... we need to 
		// make sure that our customer makes atleast 50% of what their loan amount is.
		double acceptableIncome = loanRequest.getBalance().doubleValue() * 0.50;
		
		User toEmail = userDao.getEmailById(userId);

		String to = toEmail.getEmail();
		String from = "utopiacashmoney99@gmail.com";
		final String username = "utopiacashmoney99@gmail.com";
		final String password = "UtopiaBanking100?";

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");


		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message message = new MimeMessage(session);




		if(loanRequest.getSalary() >= acceptableIncome) {
			
			loanAdd.signUpLoan(userId, loanRequest);

			try {
				message.setFrom(new InternetAddress(from));

				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(to));
				
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

		}
		else {
			try {
				message.setFrom(new InternetAddress(from));

				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(to));

				Context context = new Context();

				String html = templateEngine.process("../templates/loanRejected.html", context);

				message.setSubject("Loan Application Update!");
				message.setContent(html, "text/html");
				Transport.send(message);
			}
			catch(Exception e) {

			}

		}



	}
}
