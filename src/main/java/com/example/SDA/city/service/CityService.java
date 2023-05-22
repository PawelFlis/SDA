package com.example.SDA.city.service;

import com.example.SDA.airport.exception.AirportNotFoundException;
import com.example.SDA.city.City;
import com.example.SDA.city.dto.CityDto;
import com.example.SDA.city.exception.CityNotFoundException;
import com.example.SDA.city.mapper.CityMapper;
import com.example.SDA.city.repository.CityRepository;
import com.example.SDA.country.Country;
import com.example.SDA.country.repository.CountryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final CityMapper cityMapper;
    public List<CityDto> getAllCities() {
        return cityRepository.findAll().stream().map(cityMapper::mapToDto).toList();
    }

    public CityDto getCityById(Long id) {
        return cityMapper.mapToDto(cityRepository.findById(id).orElseThrow(()->new CityNotFoundException(id)));
    }

    public CityDto addCity(String cityName, Long countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(()->new CityNotFoundException(countryId));
        City city  = new City();
        city.setCountry(country);
        city.setName(cityName);
        cityRepository.save(city);
        return cityMapper.mapToDto(city);
    }
     public void removeCity(Long id) {
        cityRepository.deleteById(id);
     }

     @Transactional
     public CityDto updateCity (Long id, String newName) {
        City city = cityRepository.findById(id).orElseThrow(()->new CityNotFoundException(id));
        city.setName(newName);

        return cityMapper.mapToDto(city);
     }
}
