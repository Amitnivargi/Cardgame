package com.Cardgame.Cardgame;


import com.Cardgame.Cardgame.GameCard.Deck;
import com.Cardgame.Cardgame.GameCard.Game;
import com.Cardgame.Cardgame.GameCard.Player;
import com.Cardgame.Cardgame.GameCards.Card;

import java.util.ArrayList;
import java.util.List;


public class CardgameApplication {

	public static void main(String[] args) {

		List<Player> players = new ArrayList<>();
		players.add(new Player("Alice"));
		players.add(new Player("Bob"));
		players.add(new Player("Charlie"));

		// Create a new game with the players and start it
		Game game = new Game(players);
		game.start();
	}

}
