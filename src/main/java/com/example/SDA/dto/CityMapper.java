package com.example.SDA.dto;

import com.example.SDA.model.City;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CityMapper {

    public static CityDto mapCityToDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .build();
    }

    public static Set<CityDto> mapCitiesToDto(Set<City> cities) {
        return cities.stream().map(CityMapper::mapCityToDto).collect(Collectors.toSet());
    }


}
