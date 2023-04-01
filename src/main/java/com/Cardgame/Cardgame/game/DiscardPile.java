package com.Cardgame.Cardgame.game;

import com.Cardgame.Cardgame.card.Card;
import com.Cardgame.Cardgame.exception.EmptyDrawPileException;

import java.util.ArrayList;
import java.util.List;

public class DiscardPile {
    private List<Card> cards;

    public DiscardPile() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card getTopCard() throws EmptyDrawPileException {
        if (cards.isEmpty()) {
            throw new EmptyDrawPileException("The discard pile is empty.");
        }
        return cards.get(cards.size() - 1);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int topCard() {
  return 0;
    }
}
