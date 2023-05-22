package com.example.SDA.city.controller;

import com.example.SDA.city.dto.CityDto;
import com.example.SDA.city.City;
import com.example.SDA.city.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;

    @GetMapping("/all")
    public List<CityDto> getAllCities(){
        return cityService.getAllCities();
    }

    @PostMapping("/add")
    public CityDto addCity(@RequestParam String cityName, @RequestParam Long countryId){
        return cityService.addCity(cityName, countryId);
    }

    @DeleteMapping("/remove")
    public void deleteCity(@RequestParam Long id) {
        cityService.removeCity(id);
    }

    @PutMapping("/update/{id}")
    public CityDto updateCity(@PathVariable("id") Long id,@RequestParam String newName) {
        return cityService.updateCity(id,newName);
    }

    @GetMapping("/{id}")
    public CityDto getCity(@PathVariable Long id) {
        return cityService.getCityById(id);
    }
}
