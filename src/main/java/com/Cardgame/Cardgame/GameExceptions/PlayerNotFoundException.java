package com.Cardgame.Cardgame.GameExceptions;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(String message) {
        super(message);
    }
}