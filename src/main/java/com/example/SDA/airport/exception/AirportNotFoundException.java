package com.example.SDA.airport.exception;

public class AirportNotFoundException extends RuntimeException{
    public AirportNotFoundException(Long id) {
        super("There is no airport with given id " + id + " please try again.");
    }
}
