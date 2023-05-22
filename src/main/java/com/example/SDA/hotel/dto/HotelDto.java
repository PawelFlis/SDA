package com.example.SDA.hotel.dto;

import com.example.SDA.city.City;
import com.example.SDA.city.dto.CitySimpleDto;
import com.example.SDA.tour.Tour;
import com.example.SDA.tour.dto.TourSimpleDto;
import lombok.*;

import java.util.HashSet;
import java.util.List;
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
    private CitySimpleDto city;
    private List<TourSimpleDto> tours;

}
