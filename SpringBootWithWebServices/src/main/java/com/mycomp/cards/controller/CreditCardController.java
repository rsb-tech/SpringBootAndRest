package com.mycomp.cards.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mycomp.cards.bean.CardDetails;
import com.mycomp.cards.bean.CreditCard;
import com.mycomp.cards.dao.CardsDaoImpl;
import com.mycomp.cards.exception.NotFoundException;

@RestController
@ControllerAdvice
public class CreditCardController {
	@Autowired
	CardsDaoImpl cardsDao;
	@GetMapping("/allcards")
	protected List<CreditCard> getAllCards(){
		return cardsDao.getAllCardDetails();
	}
	@PostMapping("/createcards")
	private ResponseEntity<Object> createCards(@Valid @RequestBody CardDetails cardDetails){
		CardDetails cards = cardsDao.createCards(cardDetails);
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cards.getCardNumber()).toUri();
		return ResponseEntity.created(uriLocation).build();
	}
	@GetMapping("/card/{cardnumber}")
	private Resource<CreditCard> getCardDetails(@PathVariable int cardnumber){
		CreditCard cards = cardsDao.getCardDetails(cardnumber);
		if(null == cardsDao.getCardDetails(cardnumber)){
			throw new NotFoundException("The account number "+ cardnumber + " doesn't exists!");
		}
		Resource<CreditCard> res = new Resource<CreditCard>(cards);
		ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).getAllCards());
		res.add(link.withRel("allcards"));
		return res;
	}
}
