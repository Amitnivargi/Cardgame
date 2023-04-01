package com.Cardgame.Cardgame.game;

import com.Cardgame.Cardgame.card.Card;

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

    public void drawCard(Card card) {
        hand.add(card);
    }

    public Card playCard(int index) {
        if (index < 0 || index >= hand.size()) {
            throw new IndexOutOfBoundsException("Invalid card index: " + index);
        }
        return hand.remove(index);
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }

    public boolean hasWon() {
        return hand.isEmpty();
    }
}
