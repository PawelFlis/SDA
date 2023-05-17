package com.example.SDA.service;

import com.example.SDA.dto.AirportDto;
import com.example.SDA.dto.AirportMapper;
import com.example.SDA.exception.AirportNotFoundException;
import com.example.SDA.model.Airport;
import com.example.SDA.repository.AirportRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.SDA.dto.AirportMapper.mapAirportToDto;
import static com.example.SDA.dto.AirportMapper.mapAirportsToDto;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;
    public List<AirportDto> getAllAirports(){
        return mapAirportsToDto(airportRepository.findAll().stream().collect(Collectors.toSet())).stream().toList();
    }

    public AirportDto getAirportById(Long id) {
        return mapAirportToDto(Objects.requireNonNull(airportRepository.findById(id).orElse(null)));
    }
    public void addAirport(Airport airport) {
        airportRepository.save(airport);
    }

    public void removeAirport(Long id){
        airportRepository.deleteById(id);
    }
    @Transactional
    public AirportDto updateAirport (Long id, String newName) {
        Airport airport = airportRepository.findById(id).orElseThrow(()->new AirportNotFoundException(id));
        airport.setName(newName);

        return mapAirportToDto(airport);
    }
}


