package com.mycomp.cards.dao;

import java.util.List;

import com.mycomp.cards.bean.CardDetails;
import com.mycomp.cards.bean.CreditCard;

public interface CardsDao {
	public List<CreditCard> getAllCardDetails();
	public CardDetails createCards(CardDetails cardDetails);
	public CreditCard getCardDetails (int cardNumber);
}
