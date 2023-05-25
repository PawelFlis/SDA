package com.example.SDA.tour.exception;

public class FullChildCapacityException extends RuntimeException{
    public FullChildCapacityException() {
        super("Tours can no longer be booked. The limit of children has been exceeded.");
    }
}
