package com.example.SDA.controller;

import com.example.SDA.dto.AirportDto;
import com.example.SDA.model.Airport;
import com.example.SDA.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.SDA.dto.AirportMapper.mapAirportToDto;

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

    @GetMapping("/update/{id}")
    public AirportDto updateAirport(@PathVariable("id") Long id,@RequestParam String newName) {
        return airportService.updateAirport(id,newName);
    }

    @GetMapping("/airport")
    public AirportDto getAirport(@RequestParam Long id) {
        return mapAirportToDto(airportService.getAirportById(id));
    }
}
