package com.example.SDA.country.controller;

import com.example.SDA.country.dto.CountryDto;
import com.example.SDA.country.mapper.CountryMapper;
import com.example.SDA.country.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/all")
    public List<CountryDto> getAllCountries(){
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public CountryDto GetCountryById(@PathVariable Long id){
        return countryService.getById(id);
    }

    @PutMapping("/update/{id}")
    public CountryDto updateCountry(@PathVariable Long id, @RequestParam String newName){
        return countryService.update(id, newName);
    }

    @PostMapping("/add")
    public CountryDto addCountry(@RequestParam String countryName, @RequestParam Long continentId){
        return countryService.add(countryName, continentId);
    }

    @DeleteMapping("/remove/{id}")
    public void removeCountry(@PathVariable Long id) {
        countryService.removeById(id);
    }
}
