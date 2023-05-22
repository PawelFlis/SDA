package com.example.SDA.country.mapper;

import com.example.SDA.city.mapper.CityMapper;
import com.example.SDA.continent.dto.ContinentSimpleDto;
import com.example.SDA.continent.mapper.ContinentMapper;
import com.example.SDA.country.dto.CountryDto;
import com.example.SDA.country.Country;
import com.example.SDA.country.dto.CountrySimpleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountryMapper {
    private final ContinentMapper continentMapper;
    private final CityMapper cityMapper;
    public CountryDto mapToDto(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .continent(continentMapper.mapToSimpleDto(country.getContinent()))
                .cites(country.getCites().stream().map(cityMapper::mapToSimpleDto).toList())
                .build();
    }

    public CountrySimpleDto mapToSimpleDto(Country country) {
        return CountrySimpleDto.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
    }

}
