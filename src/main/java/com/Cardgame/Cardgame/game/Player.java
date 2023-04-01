package com.Cardgame.Cardgame.game;

import com.Cardgame.Cardgame.card.Rank;
import com.Cardgame.Cardgame.card.Suit;
import com.Cardgame.Cardgame.exception.InvalidCardPlayException;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final List<Deck> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Deck>();
    }

    public String getName() {
        return name;
    }

    public void drawCard(Deck card) {
        hand.add(card);
    }

    public Deck playCard(int index) {
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

    public String getHand() {
        return null;
    }

    public Deck playCard(Suit suit, Rank rank) throws InvalidCardPlayException {
        for (Deck card : hand) {
            if (card.getSuit() == suit || card.getRank() == rank) {
                hand.remove(card);
                return card;
            }
        }
        throw new InvalidCardPlayException("Cannot play a card that does not match the suit or rank of the top card on the discard pile.");
    }


}
