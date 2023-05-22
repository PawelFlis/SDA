package com.example.SDA.airport.dto;

import com.example.SDA.city.dto.CityDto;
import com.example.SDA.city.dto.CitySimpleDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportDto {

    private Long id;
    private String name;
    private CitySimpleDto city;


}
