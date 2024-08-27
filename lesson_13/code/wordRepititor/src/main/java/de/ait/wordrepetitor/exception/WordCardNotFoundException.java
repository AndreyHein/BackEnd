package de.ait.wordrepetitor.exception;

public class WordCardNotFoundException extends RuntimeException {
    public WordCardNotFoundException(String message) {
        super(message);
    }
}
