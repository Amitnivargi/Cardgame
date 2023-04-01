package com.Cardgame.Cardgame.GameExceptions;

public class EmptyDeckException extends RuntimeException {
    public EmptyDeckException(String message) {
        super(message);
    }
}