package com.Cardgame.Cardgame.GameCards;

public class Card {

    private final Suit suit;
    private final int rank;

    public Card(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        String rankString;
        switch (rank) {
            case 1:
                rankString = "Ace";
                break;
            case 11:
                rankString = "Jack";
                break;
            case 12:
                rankString = "Queen";
                break;
            case 13:
                rankString = "King";
                break;
            default:
                rankString = Integer.toString(rank);
                break;
        }
        return rankString + " of " + suit.toString();
    }

    public boolean matches(Card topCard) {
        return this.rank == topCard.rank || this.suit == topCard.suit;
    }
}
