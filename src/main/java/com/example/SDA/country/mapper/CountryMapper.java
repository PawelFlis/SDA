package com.example.SDA.country.mapper;

import com.example.SDA.country.dto.CountryDto;
import com.example.SDA.country.Country;
import com.example.SDA.country.dto.CountrySimpleDto;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class CountryMapper {

    public static CountryDto mapToDto(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
    }

    public CountrySimpleDto mapToSimpleDto(Country country) {
        return CountrySimpleDto.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
    }

}
