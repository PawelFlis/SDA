package com.example.SDA.continent.exception;

public class ContinentNotFoundException extends RuntimeException{

    public ContinentNotFoundException(Long continentId) {
        super("There is no continent with given id " + continentId + " please try again.");
    }
}
