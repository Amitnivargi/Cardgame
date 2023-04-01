package com.Cardgame.Cardgame.game;

import com.Cardgame.Cardgame.card.Card;
import com.Cardgame.Cardgame.card.Rank;
import com.Cardgame.Cardgame.card.Suit;
import com.Cardgame.Cardgame.exception.EmptyDrawPileException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;
    private Suit suit;
    private Rank rank;

    public Deck() {
        this.cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> dealCards(int n) {
        List<Card> dealtCards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dealtCards.add(cards.remove(cards.size() - 1));
        }
        return dealtCards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public List<Card> drawCards(int n) throws EmptyDrawPileException {
        if (n > cards.size()) {
            throw new EmptyDrawPileException("Cannot draw " + n + " cards, deck only has " + cards.size() + " cards.");
        }
        List<Card> drawnCards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            drawnCards.add(cards.remove(cards.size() - 1));
        }
        return drawnCards;
    }

    public Card draw() throws EmptyDrawPileException {
        if (cards.isEmpty()) {
            throw new EmptyDrawPileException("Cannot draw from an empty deck.");
        }
        return cards.remove(0);
    }

    public Suit getSuit() {
        return this.suit;

    }

    public Rank getRank() {
        return this.rank;

    }
}
