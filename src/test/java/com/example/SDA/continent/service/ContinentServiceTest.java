package com.example.SDA.continent.service;

import com.example.SDA.airport.Airport;
import com.example.SDA.airport.dto.AirportDto;
import com.example.SDA.airport.exception.AirportNotFoundException;
import com.example.SDA.continent.Continent;
import com.example.SDA.continent.dto.ContinentDto;
import com.example.SDA.continent.exception.ContinentNotFoundException;
import com.example.SDA.continent.mapper.ContinentMapper;
import com.example.SDA.continent.repository.ContinentRepository;
import com.example.SDA.country.mapper.CountryMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ContinentServiceTest {
    private ContinentRepository repository = Mockito.mock(ContinentRepository.class);
    private ContinentMapper mapper=Mockito.mock(ContinentMapper.class);
    private CountryMapper countryMapper = Mockito.mock(CountryMapper.class);
    private ContinentService service= new ContinentService(repository,mapper,countryMapper);

    @Test
    void shouldCorrectlyReturnContinentByGivenId(){
        //given
        Long id = 1L;
        Continent continent = new Continent();
        continent.setName("Atlantyda");
        continent.setCountries(null);

        ContinentDto expected = new ContinentDto();
        expected.setId(id);
        expected.setName("Atlantyda");
        expected.setCountries(null);

        when(repository.findById(id)).thenReturn(Optional.of(continent));

        //when
        ContinentDto actual = service.getById(id);
        //then
        verify(repository).findById(id);
        verify(mapper).mapToDto(continent);
    }

    @Test
    void shouldThrowExceptionWhenGivenIdIsWrong(){
        assertThatThrownBy(() -> service.getById(-1L))
                .isInstanceOf(ContinentNotFoundException.class);
    }

    @Test
    void shouldCorrectlyReturnAllContinent(){
        //given
        List<ContinentDto> continents = new ArrayList<>();
        ContinentDto continent = new ContinentDto(1L,"Afryka",null);
        ContinentDto continent2 = new ContinentDto(2L,"Atlantyda",null);
        continents.add(continent);
        continents.add(continent2);

        List<Continent> cons = new ArrayList<>();
        Continent con = new Continent(1L,"Afryka",null);
        Continent con2 = new Continent(2L,"Atlantyda",null);
        cons.add(con);
        cons.add(con2);

        when(repository.findAll()).thenReturn(cons);
        //when
        service.getAll();
        //then
        verify(repository).findAll();
        verify(mapper).mapToDto(con);
    }

}