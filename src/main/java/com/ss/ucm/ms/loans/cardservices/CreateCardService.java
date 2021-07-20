package com.ss.ucm.ms.loans.cardservices;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.ucm.ms.loans.carddao.CreateCardDAO;
import com.ss.ucm.ms.loans.carddto.CreateCardDto;
import com.ss.ucm.ms.loans.cardentities.CreateCard;


/**
 * Service Class for calling Jpa repository
 * 
 * 
 * @author Charvin Patel
 */


@Service
@Transactional
public class CreateCardService {
	
	@Autowired
	CreateCardDAO cardDAO;

	
	/**
	 * 
	 * @param CreateCardDto
	 * @return void
	 * 
	 */
	
	public void createCard(CreateCardDto cardInfo) {
		
		CreateCard card = new CreateCard();
		card.setC_type(cardInfo.getType());
		card.setName(cardInfo.getName());
		card.setApr(cardInfo.getApr());
		card.setPerks(cardInfo.getPerks());
		
		cardDAO.save(card);
		
	}
}
