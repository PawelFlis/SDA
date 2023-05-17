package com.example.SDA.controller;

import com.example.SDA.dto.CityDto;
import com.example.SDA.model.City;
import com.example.SDA.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static com.example.SDA.dto.CityMapper.mapCityToDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;

    @GetMapping("/all")
    public Set<CityDto> getAllCities(){
        return cityService.getAllCities();
    }

    @PostMapping("/add")
    public City addCity(City city){
        cityService.addCity(city);
        return city;
    }

    @DeleteMapping("/remove")
    public void deleteCity(@RequestParam Long id) {
        cityService.removeCity(id);
    }

    @GetMapping("/update/{id}")
    public CityDto updateCity(@PathVariable("id") Long id,@RequestParam String newName) {
        return cityService.updateCity(id,newName);
    }

    @GetMapping("/city")
    public CityDto getCity(@RequestParam Long id) {
        return mapCityToDto(cityService.getCityById(id));
    }
}
