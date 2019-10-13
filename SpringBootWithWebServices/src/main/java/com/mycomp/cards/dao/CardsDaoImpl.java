package com.mycomp.cards.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycomp.cards.bean.CardDetails;
import com.mycomp.cards.bean.CreditCard;

@Repository
public class CardsDaoImpl implements CardsDao{
	private static List<CreditCard> creditCard = new ArrayList<CreditCard>();
	
	public List<CreditCard> getAllCardDetails() {
		return creditCard;
	}

	public CardDetails createCards(CardDetails cardDetails) {
		if("Credit Card".equals(cardDetails.getCardType())){
			creditCard.add(new CreditCard(cardDetails));
		}
		return cardDetails;
	}

	public CreditCard getCardDetails(int cardNumber) {
		for(CreditCard credit: creditCard){
			if(credit.getCardNumber() == cardNumber)
				return credit;
		}
			return null;
	}
}
