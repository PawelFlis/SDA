package com.example.SDA.country.exception;

public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException(Long id) {
        super("There is no country with given id " + id + " please try again.");
    }
}
