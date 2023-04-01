package com.Cardgame.Cardgame.GameCard;

import com.Cardgame.Cardgame.GameCards.Card;
import com.Cardgame.Cardgame.GameExceptions.EmptyDeckException;
import com.Cardgame.Cardgame.GameExceptions.InvalidMoveException;
import com.Cardgame.Cardgame.GameExceptions.NotEnoughPlayersException;
import com.Cardgame.Cardgame.GameExceptions.PlayerNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player> players;
    private final Deck deck;
    private final List<Card> discardPile;
    private int numPlayers;
    private int currentPlayerIndex;
    private boolean gameEnded;

    public Game(List<Player> numPlayers) {
        this.players = new ArrayList<>();
        this.deck = new Deck();
        this.discardPile = new ArrayList<>();
        this.numPlayers = 0;
        this.currentPlayerIndex = 0;
        this.gameEnded = false;
    }




    public void addPlayer(Player player) {
        this.players.add(player);
        this.numPlayers++;
    }

    public void start() throws NotEnoughPlayersException, EmptyDeckException {
        if (this.numPlayers < 2) {
            throw new NotEnoughPlayersException("At least two players are required to start the game");
        }

        // Deal cards to players
        for (Player player : this.players) {
            for (int i = 0; i < 5; i++) {
                Card card = this.deck.drawCard();
                player.addCardToHand(card);
            }
        }

        // Place the top card from the deck onto the discard pile
        Card topCard = this.deck.drawCard();
        this.discardPile.add(topCard);
    }

    public void playRound(Player player, Card card) throws InvalidMoveException, PlayerNotFoundException, EmptyDeckException {
        if (this.gameEnded) {
            throw new InvalidMoveException("The game has already ended");
        }

        if (this.players.indexOf(player) != this.currentPlayerIndex) {
            throw new PlayerNotFoundException("It is not currently " + player.getName() + "'s turn");
        }

        Card topCard = this.discardPile.get(this.discardPile.size() - 1);
        if (!card.matches(topCard)) {
            throw new InvalidMoveException("The card played does not match the top card on the discard pile");
        }



        // Remove the card from the player's hand and place it on the discard pile
        player.removeCardFromHand(card);
        this.discardPile.add(card);

        // Update the current player index
        this.currentPlayerIndex = (this.currentPlayerIndex + 1) % this.numPlayers;

        // If the player has no cards left, end the game
        if (player.getNumCards() == 0) {
            this.gameEnded = true;
            System.out.println(player.getName() + " has won the game!");
        }
    }



    public boolean isGameOver() {
        for (Player player : players) {
            if (player.getNumCards() == 0) {
                return true;
            }
        }
        return false;
    }
}
