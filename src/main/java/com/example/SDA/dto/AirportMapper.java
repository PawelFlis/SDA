package com.example.SDA.dto;

import com.example.SDA.model.Airport;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AirportMapper {


    public static AirportDto mapAirportToDto(Airport airport) {
        return AirportDto.builder()
                .id(airport.getId())
                .name(airport.getName())
                .build();
    }

    public static Set<AirportDto> mapAirportsToDto(Set<Airport> airports) {
        return airports.stream().map(AirportMapper::mapAirportToDto).collect(Collectors.toSet());
    }
}
