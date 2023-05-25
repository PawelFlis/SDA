package com.example.SDA.tour.exception;

public class InvalidTourDateException extends RuntimeException {
    public InvalidTourDateException() {
        super("Incorrect date, please try again.");
    }
}
