package com.example.SDA.city.exception;

public class CityNotFoundException extends RuntimeException{

    public CityNotFoundException(Long id) {
        super("There is no city with given id " + id + " please try again.");
    }

    public CityNotFoundException(String cityName) {
        super("There is no city with given city name " + cityName+ " please try again.");
    }
}
