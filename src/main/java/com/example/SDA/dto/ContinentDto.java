package com.example.SDA.dto;

import com.example.SDA.model.Country;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContinentDto {

    private Long id;
    private String name;
    private Set<CountryDto> countries = new HashSet<>();

}
