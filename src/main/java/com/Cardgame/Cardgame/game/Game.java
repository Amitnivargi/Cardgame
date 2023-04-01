package com.Cardgame.Cardgame.game;

import com.Cardgame.Cardgame.card.Card;
import com.Cardgame.Cardgame.card.Rank;
import com.Cardgame.Cardgame.exception.EmptyDrawPileException;
import com.Cardgame.Cardgame.exception.InvalidCardPlayException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Deck deck;
    private DiscardPile discardPile;
    private List<Player> players;
    private int currentPlayerIndex;
    private boolean reverse;

    public Game() {
        deck = new Deck();
        discardPile = new DiscardPile();
        players = new ArrayList<>();
        currentPlayerIndex = 0;
        reverse = false;
    }

    public Game(Deck deck, DiscardPile discardPile, Player player1, Player player2) {
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void start() throws EmptyDrawPileException {
        deck.shuffle();
        dealCards();
        discardPile.addCard(deck.draw());
        play();
    }

    private void dealCards() {
        for (Player player : players) {
            for (int i = 0; i < 5; i++) {
                player.drawCard(deck);
            }
        }
    }

    private void play() throws EmptyDrawPileException {
        while (true) {
            Player currentPlayer = players.get(currentPlayerIndex);

            System.out.println("It is " + currentPlayer.getName() + "'s turn.");
            System.out.println("The top card on the discard pile is: " + discardPile.topCard());
            System.out.println("Your hand: " + currentPlayer.getHand());

            Card card = currentPlayer.playCard(discardPile.topCard()).draw();
            System.out.println(currentPlayer.getName() + " played " + card);

            if (card.getRank() == Rank.ACE) {
                System.out.println("Skipping the next player.");
                currentPlayerIndex = nextPlayerIndex(currentPlayerIndex);
            } else if (card.getRank() == Rank.KING) {
                System.out.println("Reversing the order of play.");
                reverse = !reverse;
                currentPlayerIndex = nextPlayerIndex(currentPlayerIndex);
            } else if (card.getRank() == Rank.QUEEN) {
                System.out.println("Adding 2 cards to the next player's hand.");
                nextPlayer().drawCard(deck);
                nextPlayer().drawCard(deck);
            } else if (card.getRank() == Rank.JACK) {
                System.out.println("Adding 4 cards to the next player's hand.");
                nextPlayer().drawCard(deck);
                nextPlayer().drawCard(deck);
                nextPlayer().drawCard(deck);
                nextPlayer().drawCard(deck);
            }

            discardPile.addCard(card);

            if (currentPlayer.hasWon()) {
                System.out.println(currentPlayer.getName() + " has won!");
                return;
            }

            currentPlayerIndex = nextPlayerIndex(currentPlayerIndex);
        }
    }

    private int nextPlayerIndex(int currentIndex) {
        if (reverse) {
            return (currentIndex - 1 + players.size()) % players.size();
        } else {
            return (currentIndex + 1) % players.size();
        }
    }

    private Player nextPlayer() {
        return players.get(nextPlayerIndex(currentPlayerIndex));
    }

    public Player getWinner() {
        return null;
    }
}
