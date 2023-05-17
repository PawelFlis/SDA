package com.example.SDA.controller;

import com.example.SDA.dto.AirportDto;
import com.example.SDA.model.Airport;
import com.example.SDA.service.AirportService;
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
    public Airport addAirport(Airport airport){
        airportService.addAirport(airport);
        return airport;
    }

    @DeleteMapping("/remove")
    public void deleteAirport(@RequestParam Long id) {
        airportService.removeAirport(id);
    }

    @PutMapping("/update/{id}")
    public AirportDto updateAirport(@PathVariable("id") Long id,@RequestParam String newName) {
        return airportService.updateAirport(id,newName);
    }

    @GetMapping("/airport")
    public AirportDto getAirport(@RequestParam Long id) {
        return airportService.getAirportById(id);
    }
}
