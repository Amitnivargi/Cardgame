package com.Cardgame.Cardgame.GameCards;

public class ActionCard extends Card {
    public enum Action {
        SKIP_NEXT_PLAYER,
        REVERSE_PLAY_ORDER,
        DRAW_TWO_CARDS,
        DRAW_FOUR_CARDS
    }

    private final Action action;

    public ActionCard(Suit suit, int rank, Action action) {
        super(suit, rank);
        this.action = action;
    }

    public Action getAction() {
        return action;
    }
}