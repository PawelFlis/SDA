package com.example.SDA.country.dto;

import com.example.SDA.city.City;
import com.example.SDA.city.dto.CitySimpleDto;
import com.example.SDA.continent.Continent;
import com.example.SDA.continent.dto.ContinentSimpleDto;
import lombok.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryDto {
    private Long id;
    private String name;
    private ContinentSimpleDto continent;
    private List<CitySimpleDto> cites ;

}
