//package com.ss.ucm.ms.loans.cardservices;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ss.ucm.ms.loans.carddao.CreateCardDAO;
//import com.ss.ucm.ms.loans.carddto.CreateCardDto;
//import com.ss.ucm.ms.loans.cardentities.CreateCard;
//
//
///**
// * Service Class for calling Jpa repository
// * 
// * 
// * @author Charvin Patel
// */
//
//
//@Service
//@Transactional
//public class CreateCardService {
//	
//	@Autowired
//	CreateCardDAO cardDAO;
//
//	
//	/**
//	 * 
//	 * @param CreateCardDto
//	 * @return void
//	 * 
//	 */
//	
//	public void createCard(CreateCardDto cardInfo) {
//		
//		CreateCard card = new CreateCard();
//		card.setC_type(cardInfo.getType());
//		card.setName(cardInfo.getName());
//		card.setApr(cardInfo.getApr());
//		card.setPerks(cardInfo.getPerks());
//		
//		cardDAO.save(card);
//		
//	}
//}

package com.ss.ucm.ms.loans.cardservices;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.ucm.ms.loans.dao.AccountTypeDAO;
import com.ss.ucm.ms.loans.dto.RequestAccountTypeDto;
import com.ss.ucm.ms.loans.entities.AccountType;


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
	AccountTypeDAO createCardDao;

	
	/**
	 * 
	 * @param CreateCardDto
	 * @return void
	 * 
	 */
	
	public void createCard(RequestAccountTypeDto cardInfo) {
		
		AccountType createCard = new AccountType();
		
		
		createCard.setName(cardInfo.getName());
		createCard.setType(cardInfo.getType());
		
		// This is for type debit 
		createCard.setAllow_credit(false);
		
		// This is for type debit 
		createCard.setCredit_limit(BigDecimal.valueOf(0.00));
		
		// For debit cards related to checking account
		createCard.setAllow_cards(true);
		
		// This is for type debit 
		createCard.setApr(BigDecimal.valueOf(0.00));
		
		createCard.setPerks(cardInfo.getPerks());
		
		if(cardInfo.getType().equals("CREDIT") || cardInfo.getType().equals("LOAN")) {
			createCard.setAllow_credit(true);
			createCard.setCredit_limit(cardInfo.getCredit_limit());
			createCard.setApr(cardInfo.getApr());
		}
		
		
		createCardDao.save(createCard);
		
	}
}

