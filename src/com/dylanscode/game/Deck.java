package com.dylanscode.game;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

import com.dylanscode.game.Card.Rank;
import com.dylanscode.game.Card.Suite;

public class Deck {
	Stack<Card> deck;

	public Deck() {
		deck = generateRandomDeck();
	}

	public Stack<Card> generateRandomDeck() {
		Card[] temp_deck = new Card[24];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				temp_deck[4 * i + j] = new Card(Rank.values()[i], Suite.values()[j]);
			}
		}
		Collections.shuffle(Arrays.asList(temp_deck));
		Stack<Card> deck = new Stack<Card>();
		deck.addAll(Arrays.asList(temp_deck));
		return deck;
	}

	public Card peek() {
		return deck.peek();
	}

	public Card pop() {
		return deck.pop();
	}

	public void push(Card card) {
		deck.push(card);
	}
}
