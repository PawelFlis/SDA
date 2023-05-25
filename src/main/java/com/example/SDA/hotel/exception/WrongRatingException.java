package com.example.SDA.hotel.exception;

public class WrongRatingException extends RuntimeException {
    public WrongRatingException(Integer raiting) {
        super("Wrong rating " + raiting + ", try again.");
    }
}
