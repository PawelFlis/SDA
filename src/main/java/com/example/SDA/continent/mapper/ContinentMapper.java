package com.example.SDA.continent.mapper;

import com.example.SDA.continent.dto.ContinentDto;
import com.example.SDA.continent.Continent;
import com.example.SDA.continent.dto.ContinentSimpleDto;
import com.example.SDA.country.Country;
import org.springframework.stereotype.Component;

@Component
public class ContinentMapper {

    public ContinentDto mapToDto(Continent continent) {
        return ContinentDto.builder()
                .id(continent.getId())
                .name(continent.getName())
                .countries(continent.getCountries().stream().map(Country::getName).toList())
                .build();
    }

    public ContinentSimpleDto mapToSimpleDto(Continent continent) {
        return ContinentSimpleDto.builder()
                .id(continent.getId())
                .name(continent.getName())
                .build();
    }
}
