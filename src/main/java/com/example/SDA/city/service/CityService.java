package com.example.SDA.city.service;

import com.example.SDA.airport.dto.AirportDto;
import com.example.SDA.airport.exception.AirportNotFoundException;
import com.example.SDA.airport.mapper.AirportMapper;
import com.example.SDA.city.City;
import com.example.SDA.city.dto.CityDto;
import com.example.SDA.city.exception.CityNotFoundException;
import com.example.SDA.city.mapper.CityMapper;
import com.example.SDA.city.repository.CityRepository;
import com.example.SDA.country.Country;
import com.example.SDA.country.repository.CountryRepository;
import com.example.SDA.hotel.dto.HotelDto;
import com.example.SDA.hotel.exception.WrongRatingException;
import com.example.SDA.hotel.mapper.HotelMapper;
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
    private final AirportMapper airportMapper;
    private final HotelMapper hotelMapper;
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

     public List<AirportDto> getAllCityAirports (String cityName) {
         City city = cityRepository.findCityByName(cityName).orElseThrow(() -> new CityNotFoundException(cityName));
         return city.getAirports().stream().map(airportMapper::mapToDto).toList();
     }

    public List<HotelDto> findHotelsByRatingInCity (String cityName, Integer rating) {
        if (rating < 0 || rating > 5) {
            throw new WrongRatingException(rating);
        }
        City city = cityRepository.findCityByName(cityName).orElseThrow(() -> new CityNotFoundException(cityName));
        return city.getHotels().stream().filter(hotel->hotel.getStandard()==rating).map(hotelMapper::mapToDto).toList();
    }
}
