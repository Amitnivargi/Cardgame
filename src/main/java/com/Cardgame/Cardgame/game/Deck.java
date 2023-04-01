package com.Cardgame.Cardgame.game;

import com.Cardgame.Cardgame.card.Card;
import com.Cardgame.Cardgame.card.Rank;
import com.Cardgame.Cardgame.card.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = createDeck();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.remove(0);
    }

    private List<Card> createDeck() {
        List<Card> deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit,rank);
                deck.add(card);
            }
        }
        return deck;
    }
}
