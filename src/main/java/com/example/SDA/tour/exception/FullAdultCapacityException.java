package com.example.SDA.tour.exception;

public class FullAdultCapacityException extends RuntimeException{
    public FullAdultCapacityException() {
        super("Tours can no longer be booked. The limit of adults has been exceeded.");
    }
}
