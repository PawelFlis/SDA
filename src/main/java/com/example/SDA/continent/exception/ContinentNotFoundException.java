package com.example.SDA.continent.exception;

public class ContinentNotFoundException extends RuntimeException{

    public ContinentNotFoundException(Long continentId) {
        super("There is no continent with given id " + continentId + " please try again.");
    }

    public ContinentNotFoundException(String continentName) {
        super("There is no continent with given name " + continentName + ", please try again.");
    }
}
