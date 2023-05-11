package com.example.SDA.dto;

import com.example.SDA.model.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.SDA.dto.ContinentMapper.mapContinentToDto;

@Component
//@RequiredArgsConstructor
public class CountryMapper {

    //private final ContinentMapper continentMapper;
    public static CountryDto mapCountryToDto(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .continent(mapContinentToDto(country.getContinent()))
                .build();
    }

    public static Set<CountryDto> mapCountriesToDto(Set<Country> countries) {
        return countries.stream().map(CountryMapper::mapCountryToDto).collect(Collectors.toSet());
    }

}
