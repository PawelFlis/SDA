package com.example.SDA.continent.dto;

import com.example.SDA.country.dto.CountryDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContinentDto {

    private Long id;
    private String name;
    private List<String> countries;

}
