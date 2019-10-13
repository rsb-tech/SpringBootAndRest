package com.mycomp.cards.bean;

public class CardsBean {
	private String cards;

	public CardsBean(String cards) {
		this.cards = cards;
	}

	public String getCards() {
		return cards;
	}

	public void setCards(String cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return String.format("CardsBean [cards=%s]", cards);
	}

}
