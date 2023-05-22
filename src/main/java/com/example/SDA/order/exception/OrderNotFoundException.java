package com.example.SDA.order.exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Long id) {
        super("There is no order with given id " + id + " please try again.");
    }
}
