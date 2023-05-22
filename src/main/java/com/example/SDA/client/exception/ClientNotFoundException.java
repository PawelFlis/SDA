package com.example.SDA.client.exception;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(Long id) {
        super("There is no client with given id " + id + " please try again.");
    }
}
