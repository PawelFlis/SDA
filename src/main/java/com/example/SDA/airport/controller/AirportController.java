package com.example.SDA.airport.controller;

import com.example.SDA.airport.dto.AirportDto;
import com.example.SDA.airport.Airport;
import com.example.SDA.airport.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/airports")
public class AirportController {
    private final AirportService airportService;

    @GetMapping("/all")
    public List<AirportDto> getAllAirports(){
        return airportService.getAllAirports();
    }

    @PostMapping("/add")
    public AirportDto addAirport( @RequestParam String airportName, @RequestParam Long cityId){
        return airportService.addAirport(airportName, cityId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteAirport(@PathVariable("id") Long id) {
        airportService.removeAirport(id);
    }

    @PutMapping("/update/{id}")
    public AirportDto updateAirport(@PathVariable("id") Long id,@RequestParam String newName) {
        return airportService.updateAirport(id,newName);
    }

    @GetMapping("/{id}")
    public AirportDto getAirport(@PathVariable("id") Long airportId) {
        return airportService.getAirportById(airportId);
    }
}
