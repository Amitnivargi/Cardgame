package com.Cardgame.Cardgame;

import com.Cardgame.Cardgame.exception.EmptyDrawPileException;
import com.Cardgame.Cardgame.game.Deck;
import com.Cardgame.Cardgame.game.DiscardPile;
import com.Cardgame.Cardgame.game.Game;
import com.Cardgame.Cardgame.game.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class CardgameApplication {

	public static void main(String[] args) throws EmptyDrawPileException {
		Deck deck = new Deck(); // create a new deck
		deck.shuffle(); // shuffle the deck

		// create two players
		Player player1 = new Player("Alice");
		Player player2 = new Player("Bob");

		// deal 7 cards to each player
		for (int i = 0; i < 7; i++) {
			player1.drawCard(deck);
			player2.drawCard(deck);
		}

		// create a discard pile
		DiscardPile discardPile = new DiscardPile();

		// play the game
		Game game = new Game(deck, discardPile, player1, player2);
		game.start();

		// print the winner's name
		System.out.println("The winner is " + game.getWinner().getName() + "!");
	}

}
