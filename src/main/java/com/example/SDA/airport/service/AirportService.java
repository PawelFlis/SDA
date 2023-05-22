package com.example.SDA.airport.service;

import com.example.SDA.airport.dto.AirportDto;
import com.example.SDA.airport.mapper.AirportMapper;
import com.example.SDA.airport.exception.AirportNotFoundException;
import com.example.SDA.airport.Airport;
import com.example.SDA.airport.repository.AirportRepository;
import com.example.SDA.city.City;
import com.example.SDA.city.exception.CityNotFoundException;
import com.example.SDA.city.repository.CityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;
    private final CityRepository cityRepository;
    private final AirportMapper airportMapper;
    public List<AirportDto> getAllAirports(){
        return airportRepository.findAll().stream().map(airportMapper::mapToDto).toList();
    }

    public AirportDto getAirportById(Long id) {
        return airportMapper.mapToDto(Objects.requireNonNull(airportRepository.findById(id).orElseThrow(()->new AirportNotFoundException(id))));
    }
    public AirportDto addAirport(String airportName, Long cityId) {
        City city = cityRepository.findById(cityId).orElseThrow(()->new CityNotFoundException(cityId));
        Airport airport = new Airport();
        airport.setName(airportName);
        airport.setCity(city);
        airportRepository.save(airport);
        return airportMapper.mapToDto(airport);
    }

    public void removeAirport(Long id){
        airportRepository.deleteById(id);
    }

    @Transactional
    public AirportDto updateAirport (Long id, String newName) {
        Airport airport = airportRepository.findById(id).orElseThrow(()->new AirportNotFoundException(id));
        airport.setName(newName);
        return airportMapper.mapToDto(airport);
    }
}


