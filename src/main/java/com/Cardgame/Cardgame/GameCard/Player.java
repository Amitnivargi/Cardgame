package com.Cardgame.Cardgame.GameCard;

import com.Cardgame.Cardgame.GameCards.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void removeCardFromHand(Card card) {
        hand.remove(card);
    }

    public boolean hasCardInHand(Card card) {
        return hand.contains(card);
    }

    public int getHandSize() {
        return hand.size();
    }

    public int getNumCards() {
        return hand.size();
    }
}
