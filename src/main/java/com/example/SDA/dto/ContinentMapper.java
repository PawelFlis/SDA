package com.example.SDA.dto;

import com.example.SDA.model.Continent;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
//@RequiredArgsConstructor
public class ContinentMapper {

    public static ContinentDto mapContinentToDto(Continent continent) {
        return ContinentDto.builder()
                .id(continent.getId())
                .name(continent.getName())
                .build();
    }

    public static Set<ContinentDto> mapContinentsToDto(Set<Continent> continents) {
        return continents.stream().map(ContinentMapper::mapContinentToDto).collect(Collectors.toSet());
    }
}
