package com.example.SDA.dto;

import com.example.SDA.model.Country;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
//@RequiredArgsConstructor
public class CountryMapper {

    public static CountryDto mapCountryToDto(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
    }

    public static Set<CountryDto> mapCountriesToDto(Set<Country> countries) {
        return countries.stream().map(CountryMapper::mapCountryToDto).collect(Collectors.toSet());
    }

}
