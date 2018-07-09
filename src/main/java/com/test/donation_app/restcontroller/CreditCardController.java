package com.test.donation_app.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.donation_app.entities.CreditCard;
import com.test.donation_app.entities.User;
import com.test.donation_app.pojo.CreditCardPojo;
import com.test.donation_app.service.CreditCardService;
import com.test.donation_app.service.CreditCardTypeService;
import com.test.donation_app.service.UserService;
import com.test.donation_app.util.ToolKit;

import javassist.NotFoundException;

@RestController
@RequestMapping("/creditcard")
public class CreditCardController {

	@Autowired
	UserService userService;
	
	@Autowired
	CreditCardService creditCardService;
	
	@Autowired
	CreditCardTypeService creditCardTypeService;
	
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public CreditCard save( @RequestBody CreditCard creditCard) throws NotFoundException {
		User u=userService.findByUserName(ToolKit.getLoggedUserName());
		creditCard.setUser(u);
		return creditCardService.save(creditCard);
	}
	
	@GetMapping("/find")
	public List<CreditCardPojo> find() {
		List<CreditCard> creditCards=creditCardService.findCreditCardByUserName(ToolKit.getLoggedUserName());
		List<CreditCardPojo> creditCardsPojo=new ArrayList<>();
		for (CreditCard creditCard: creditCards) {
			CreditCardPojo c=new CreditCardPojo();
			c.setCardNumber(creditCard.getCardNumber());
			c.setIdCard(creditCard.getIdCreditCard());
			creditCardsPojo.add(c);
		}
		return creditCardsPojo;
	}
	
	@PostMapping("/validate")
	public boolean validate( @RequestBody CreditCard creditCard) {
		CreditCard c =creditCardService.validateCreditCard(creditCard.getCardNumber(), creditCard.getSecurityCode());
		if(c==null) {
			return false;
		}else {
			return true;	
		}
	}
	
	
}
