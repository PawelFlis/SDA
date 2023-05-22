package com.example.SDA.hotel.exception;

public class HotelNotFoundException extends RuntimeException{
    public HotelNotFoundException(Long id) {
        super("There is no hotel with given id " + id + " please try again.");
    }
}
