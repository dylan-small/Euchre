package com.dylanscode.game;

public class Card {
	
	enum Rank {
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING,
		ACE
	}
	
	enum Suite{
		DIAMONDS,
		HEARTS,
		CLUBS,
		SPADES
	}
	
	private Rank rank;
	private Suite suite;
	
	protected Card(Rank rank, Suite suite) {
		this.rank = rank;
		this.suite = suite;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suite getSuite() {
		return suite;
	}

	public void setSuite(Suite suite) {
		this.suite = suite;
	}
	
}
