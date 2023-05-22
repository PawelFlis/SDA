package com.example.SDA.continent.mapper;

import com.example.SDA.continent.dto.ContinentDto;
import com.example.SDA.continent.Continent;
import com.example.SDA.continent.dto.ContinentSimpleDto;
import com.example.SDA.country.Country;
import com.example.SDA.country.mapper.CountryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ContinentMapper {
    private final CountryMapper countryMapper;
    public ContinentMapper(@Lazy CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }
    public ContinentDto mapToDto(Continent continent) {
        return ContinentDto.builder()
                .id(continent.getId())
                .name(continent.getName())
                .countries(continent.getCountries().stream().map(countryMapper::mapToSimpleDto).toList())
                .build();
    }

    public ContinentSimpleDto mapToSimpleDto(Continent continent) {
        return ContinentSimpleDto.builder()
                .id(continent.getId())
                .name(continent.getName())
                .build();
    }
}
