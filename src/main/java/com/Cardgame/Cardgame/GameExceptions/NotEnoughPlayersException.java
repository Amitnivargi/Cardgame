package com.Cardgame.Cardgame.GameExceptions;

public class NotEnoughPlayersException extends RuntimeException {
    public NotEnoughPlayersException(String message) {
        super(message);
    }
}