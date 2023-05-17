package com.example.SDA.service;

import com.example.SDA.dto.AirportDto;
import com.example.SDA.model.Airport;
import com.example.SDA.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.SDA.dto.AirportMapper.mapAirportToDto;
import static com.example.SDA.dto.AirportMapper.mapAirportsToDto;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;
    public List<AirportDto> getAllAirports(){
        return mapAirportsToDto(airportRepository.findAll().stream().collect(Collectors.toSet())).stream().toList();
    }

    public Airport getAirportById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }
    public void addAirport(Airport airport) {
        airportRepository.save(airport);
    }

    public void removeAirport(Long id){
        airportRepository.deleteById(id);
    }

    public AirportDto updateAirport (Long id, String newName) {
        Airport airport = getAirportById(id);
        airport.setName(newName);
        airportRepository.save(airport);
        return mapAirportToDto(airport);
    }
}


