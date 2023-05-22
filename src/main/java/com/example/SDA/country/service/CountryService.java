package com.example.SDA.country.service;

import com.example.SDA.airport.Airport;
import com.example.SDA.continent.Continent;
import com.example.SDA.continent.exception.ContinentNotFoundException;
import com.example.SDA.continent.repository.ContinentRepository;
import com.example.SDA.country.Country;
import com.example.SDA.country.dto.CountryDto;
import com.example.SDA.country.exception.CountryNotFoundException;
import com.example.SDA.country.mapper.CountryMapper;
import com.example.SDA.country.repository.CountryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;
    private final ContinentRepository continentRepository;

    public List<CountryDto> getAll(){
        return countryRepository.findAll().stream().map(countryMapper::mapToDto).toList();
    }

    public CountryDto getById(Long id) {
        return countryMapper.mapToDto(countryRepository.findById(id).orElseThrow(()->new CountryNotFoundException(id)));
    }

    @Transactional
    public CountryDto update (Long id, String newName) {
        Country country = countryRepository.findById(id).orElseThrow(()->new CountryNotFoundException(id));
        country.setName(newName);
        return countryMapper.mapToDto(country);
    }

    public CountryDto add (String countryName, Long continentId){
        Continent continent = continentRepository.findById(continentId).orElseThrow(()->new ContinentNotFoundException(continentId));
        Country country = new Country();
        country.setName(countryName);
        country.setContinent(continent);
        countryRepository.save(country);
        return countryMapper.mapToDto(country);
    }

    public void removeById(Long id) {
        countryRepository.deleteById(id);
    }
}
