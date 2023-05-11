package com.example.SDA.dto;

import com.example.SDA.model.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.SDA.dto.AirportMapper.mapAirportsToDto;
import static com.example.SDA.dto.CountryMapper.mapCountryToDto;
import static com.example.SDA.dto.HotelMapper.mapHotelsToDto;
import static com.example.SDA.dto.TourMapper.mapToursToDto;

@Component
//@RequiredArgsConstructor
public class CityMapper {

    public static CityDto mapCityToDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .country(mapCountryToDto(city.getCountry()))
                .airports(mapAirportsToDto(city.getAirports()))
                .hotels(mapHotelsToDto(city.getHotels()))
                .toursFrom(mapToursToDto(city.getToursFrom()))
                .toursTo(mapToursToDto(city.getToursTo()))
                .build();
    }

    public static Set<CityDto> mapCitiesToDto(Set<City> cities) {
        return cities.stream().map(CityMapper::mapCityToDto).collect(Collectors.toSet());
    }


}
