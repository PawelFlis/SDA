package com.example.SDA.tour.exception;

public class TourNotFoundException extends RuntimeException{
    public TourNotFoundException(Long id) {
        super("There is no tour with given id " + id + " please try again.");
    }
}
