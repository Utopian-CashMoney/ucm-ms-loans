package com.ss.ucm.ms.loans.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ss.ucm.ms.loans.entities.AccountType;

@Repository
public interface AccountTypeDAO extends JpaRepository<AccountType, Integer>{

	
	 @Query(value = "SELECT * FROM account_type WHERE type = :type", nativeQuery = true)
	public Collection<AccountType> getLoans(String type);
	 
	 
	//public AccountType getIdByName(String name);
	 
	 public AccountType getAccountTypeByName(String name);

	
}
