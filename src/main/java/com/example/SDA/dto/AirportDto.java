package com.example.SDA.dto;

import com.example.SDA.model.City;
import com.example.SDA.model.Tour;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportDto {

    private Long id;
    private String name;
    private CityDto city;
    private Set<TourDto> toursFrom = new HashSet<>();
    private Set<TourDto> toursTo = new HashSet<>();

}
