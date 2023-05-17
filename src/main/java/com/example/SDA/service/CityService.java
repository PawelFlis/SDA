package com.example.SDA.service;

import com.example.SDA.dto.CityDto;
import com.example.SDA.model.City;
import com.example.SDA.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.SDA.dto.CityMapper.mapCitiesToDto;
import static com.example.SDA.dto.CityMapper.mapCityToDto;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public Set<CityDto> getAllCities() {
        return mapCitiesToDto(cityRepository.findAll().stream().collect(Collectors.toSet()));
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public void addCity(City city) {
        cityRepository.save(city);
    }
     public void removeCity(Long id) {
        cityRepository.deleteById(id);
     }

     public CityDto updateCity (Long id, String newName) {
        City city = getCityById(id);
        city.setName(newName);
        cityRepository.save(city);
        return mapCityToDto(city);
     }
}
