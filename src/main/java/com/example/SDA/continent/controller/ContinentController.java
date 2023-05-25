package com.example.SDA.continent.controller;

import com.example.SDA.continent.dto.ContinentDto;
import com.example.SDA.continent.service.ContinentService;
import com.example.SDA.country.dto.CountryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/continents")
public class ContinentController {

    private final ContinentService continentService;

    @GetMapping("/all")
    public List<ContinentDto> getAllContinents() {
        return continentService.getAll();
    }

    @GetMapping("/{id}")
    public ContinentDto getContinentById(@PathVariable("id") Long continentId){
        return continentService.getById(continentId);
    }

    @GetMapping("/{continentName}/countries")
    public List<CountryDto> getCountriesByContinent (@PathVariable String continentName) {
        return continentService.findCountriesByContinent(continentName);
    }
}
