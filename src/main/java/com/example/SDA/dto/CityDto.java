package com.example.SDA.dto;

import com.example.SDA.model.Airport;
import com.example.SDA.model.Country;
import com.example.SDA.model.Hotel;
import com.example.SDA.model.Tour;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityDto {
    private Long id;
    private String name;
    private CountryDto country;
    private Set<AirportDto> airports = new HashSet<>();
    private Set<HotelDto> hotels = new HashSet<>();
    private  Set<TourDto> toursFrom = new HashSet<>();
    private  Set<TourDto> toursTo = new HashSet<>();
}
