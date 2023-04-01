package com.Cardgame.Cardgame.GameCard;

import com.Cardgame.Cardgame.GameCards.Card;
import com.Cardgame.Cardgame.GameCards.Suit;
import com.Cardgame.Cardgame.GameExceptions.EmptyDeckException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (int i = 1; i <= 13; i++) {
                cards.add(new Card(suit, i));
            }
        }
        shuffle();
    }

    public int size() {
        return cards.size();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        if (cards.isEmpty()) {
            throw new EmptyDeckException("Cannot draw from an empty deck");
        }
        return cards.remove(0);
    }

    public void addToBottom(Card card) {
        cards.add(card);
    }

    public void addToTop(Card card) {
        cards.add(0, card);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new EmptyDeckException("Cannot draw from an empty deck");
        }
        return cards.remove(0);
    }
}