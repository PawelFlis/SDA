package com.example.SDA.city.mapper;

import com.example.SDA.airport.mapper.AirportMapper;
import com.example.SDA.city.dto.CityDto;
import com.example.SDA.city.City;
import com.example.SDA.city.dto.CitySimpleDto;
import com.example.SDA.country.mapper.CountryMapper;
import com.example.SDA.hotel.mapper.HotelMapper;
import com.example.SDA.tour.mapper.TourMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    private final CountryMapper countryMapper;
    private final AirportMapper airportMapper;
    private final HotelMapper hotelMapper;
    private final TourMapper tourMapper;

    public CityMapper(@Lazy CountryMapper countryMapper,@Lazy AirportMapper airportMapper,@Lazy  HotelMapper hotelMapper,@Lazy  TourMapper tourMapper) {
        this.countryMapper = countryMapper;
        this.airportMapper = airportMapper;
        this.hotelMapper = hotelMapper;
        this.tourMapper = tourMapper;
    }

    public CityDto mapToDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .country(countryMapper.mapToSimpleDto(city.getCountry()))
                .airports(city.getAirports().stream().map(airportMapper::mapToSimpleDto).toList())
                .hotels(city.getHotels().stream().map(hotelMapper::mapToSimpleDto).toList())
                .toursFrom(city.getToursFrom().stream().map(tourMapper::mapToSimpleDto).toList())
                .toursTo(city.getToursTo().stream().map(tourMapper::mapToSimpleDto).toList())
                .build();
    }

public CitySimpleDto mapToSimpleDto(City city) {
        return CitySimpleDto.builder()
                .id(city.getId())
                .name(city.getName())
                .build();
}



}
