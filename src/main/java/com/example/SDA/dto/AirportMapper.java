package com.example.SDA.dto;

import com.example.SDA.model.Airport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.SDA.dto.CityMapper.mapCityToDto;
import static com.example.SDA.dto.TourMapper.mapToursToDto;

@Component
//@RequiredArgsConstructor
public class AirportMapper {

    //private final TourMapper tourMapper;
    //private final CityMapper cityMapper;
    public static AirportDto mapAirportToDto(Airport airport) {
        return AirportDto.builder()
                .id(airport.getId())
                .name(airport.getName())
                .city(mapCityToDto( airport.getCity()))
                .toursFrom(mapToursToDto(airport.getToursFrom()))
                .toursTo(mapToursToDto(airport.getToursTo()))
                .build();
    }

    public static Set<AirportDto> mapAirportsToDto(Set<Airport> airports) {
        return airports.stream().map(AirportMapper::mapAirportToDto).collect(Collectors.toSet());
    }
}
