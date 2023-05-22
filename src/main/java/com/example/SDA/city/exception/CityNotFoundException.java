package com.example.SDA.city.exception;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException(Long id) {
        super("There is no city with given id " + id + " please try again.");
    }
}
