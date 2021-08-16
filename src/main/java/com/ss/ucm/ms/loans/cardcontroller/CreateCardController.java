package com.ss.ucm.ms.loans.cardcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.ucm.ms.loans.carddto.CreateCardDto;
import com.ss.ucm.ms.loans.cardservices.CreateCardService;


/**
 * Controller Class for Handling API calls
 * 
 * 
 * @author Charvin Patel
 */


@RestController
@RequestMapping("/cards")
@CrossOrigin
public class CreateCardController {

	
	@Autowired
	CreateCardService cardService;
	
	/**
	 * 
	 * @param CreateCardDto
	 * @return void
	 * 
	 */
	
	@PostMapping("/create_card")
	public void createCard(@RequestBody CreateCardDto cardInfo) {
		System.out.println("Type: " + cardInfo.getType());
		cardService.createCard(cardInfo);
	}
	
}
