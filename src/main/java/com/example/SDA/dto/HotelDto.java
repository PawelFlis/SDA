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
public class HotelDto {
    private Long id;
    private String name;
    private int standard;
    private String note;
    private CityDto city;
    private Set<TourDto> tours = new HashSet<>();
}
