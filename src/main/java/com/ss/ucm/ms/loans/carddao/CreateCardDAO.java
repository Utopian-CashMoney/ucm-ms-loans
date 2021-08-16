package com.ss.ucm.ms.loans.carddao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.ucm.ms.loans.cardentities.CreateCard;

@Repository
public interface CreateCardDAO extends JpaRepository<CreateCard, Integer> {
	

}
