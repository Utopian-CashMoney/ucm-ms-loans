package com.ss.ucm.ms.loans.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.ucm.ms.loans.entities.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
	
	/**
	 * 
	 * @param id
	 * @return User entity
	 * 
	 */
	public User getEmailById(int id);
	

}
