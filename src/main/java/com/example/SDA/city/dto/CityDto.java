package com.example.SDA.city.dto;

import com.example.SDA.airport.dto.AirportSimpleDto;
import com.example.SDA.country.dto.CountrySimpleDto;
import com.example.SDA.hotel.dto.HotelSimpleDto;
import com.example.SDA.tour.dto.TourSimpleDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityDto {
    private Long id;
    private String name;
    private CountrySimpleDto country;
    private List<AirportSimpleDto> airports;
    private List<HotelSimpleDto> hotels;
    private List<TourSimpleDto> toursFrom;
    private List<TourSimpleDto> toursTo;


}
