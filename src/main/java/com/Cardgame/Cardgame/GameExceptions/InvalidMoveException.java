package com.Cardgame.Cardgame.GameExceptions;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(String message) {
        super(message);
    }
}