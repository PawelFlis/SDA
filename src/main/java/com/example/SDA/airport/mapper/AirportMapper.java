package com.example.SDA.airport.mapper;

import com.example.SDA.airport.Airport;
import com.example.SDA.airport.dto.AirportDto;
import com.example.SDA.airport.dto.AirportSimpleDto;
import com.example.SDA.city.mapper.CityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AirportMapper {

    private final CityMapper cityMapper;

    public AirportDto mapToDto(Airport airport) {
        return AirportDto.builder()
                .id(airport.getId())
                .name(airport.getName())
                .city(cityMapper.mapToSimpleDto(airport.getCity()))
                .build();
    }

    public AirportSimpleDto mapToSimpleDto(Airport airport) {
        return AirportSimpleDto.builder()
                .id(airport.getId())
                .name(airport.getName())
                .build();
    }
}
