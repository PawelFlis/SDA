package com.example.SDA.dto;

import com.example.SDA.model.City;
import com.example.SDA.model.Continent;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryDto {
    private Long id;
    private String name;
    private ContinentDto continent;
    private Set<CityDto> cites = new HashSet<>();
}
