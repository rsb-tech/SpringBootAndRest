package com.mycomp.cards.bean;

public class CreditCard{
	
	private int cardNumber;
	private CardDetails cardDetails;
	
	public CreditCard(CardDetails cardDetails) {
		super();
		this.cardDetails = cardDetails;
	}
	public int getCardNumber() {
		cardNumber = cardDetails.getCardNumber();
		return cardNumber;
	}
	public CardDetails getCardDetails() {
		return cardDetails;
	}
	public void setCardDetails(CardDetails cardDetails) {
		this.cardDetails = cardDetails;
	}

}
