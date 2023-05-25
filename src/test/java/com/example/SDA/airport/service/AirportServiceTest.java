package com.example.SDA.airport.service;

import com.example.SDA.airport.Airport;
import com.example.SDA.airport.dto.AirportDto;
import com.example.SDA.airport.exception.AirportNotFoundException;
import com.example.SDA.airport.mapper.AirportMapper;
import com.example.SDA.airport.repository.AirportRepository;
import com.example.SDA.city.City;
import com.example.SDA.city.repository.CityRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AirportServiceTest {

    private AirportRepository airportRepository = Mockito.mock(AirportRepository.class);
    private CityRepository cityRepository= Mockito.mock(CityRepository.class);
    private AirportMapper airportMapper= Mockito.mock(AirportMapper.class);
    private AirportService airportService=new AirportService(airportRepository,cityRepository,airportMapper);

    @Test
    void shouldCorrectlyReturnAirportByGivenId(){
        //given
        Long id = 1L;
        Airport airport = new Airport();
        airport.setName("Lotnisko w Warszawie");
        airport.setCity(null);
        airport.setToursFrom(new HashSet<>());
        airport.setToursTo(new HashSet<>());

        AirportDto expected = new AirportDto();
        expected.setId(id);
        expected.setName("Lotnisko w Warszawie");
        expected.setCity(null);

        when(airportRepository.findById(id)).thenReturn(Optional.of(airport));

        //when
        AirportDto actual = airportService.getAirportById(id);
        //then
        verify(airportRepository).findById(id);
        verify(airportMapper).mapToDto(airport);
    }

        @Test
        void shouldThrowExceptionWhenGivenIdIsWrong(){
            assertThatThrownBy(() -> airportService.getAirportById(-1L))
                    .isInstanceOf(AirportNotFoundException.class);
        }
}