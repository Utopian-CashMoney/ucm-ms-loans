package com.ss.ucm.ms.loans.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.ucm.ms.loans.entities.User;
import com.ss.ucm.ms.loans.entities.UserAccount;
import com.ss.ucm.ms.loans.entities.UserLoan;


@Repository
public interface UserAccountDAO extends JpaRepository<UserAccount, String> {

	public UserAccount getUserIDByaccountNumber(String account_number);
	
	public Collection<UserAccount> getUserAccountByUserId(int user);

}
