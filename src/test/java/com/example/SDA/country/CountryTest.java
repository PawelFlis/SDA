package com.example.SDA.country;

import com.example.SDA.continent.Continent;
import com.example.SDA.continent.dto.ContinentDto;
import com.example.SDA.continent.exception.ContinentNotFoundException;
import com.example.SDA.continent.repository.ContinentRepository;
import com.example.SDA.country.dto.CountryDto;
import com.example.SDA.country.exception.CountryNotFoundException;
import com.example.SDA.country.mapper.CountryMapper;
import com.example.SDA.country.repository.CountryRepository;
import com.example.SDA.country.service.CountryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CountryTest {
    private CountryRepository countryRepository= Mockito.mock(CountryRepository.class);
    private CountryMapper countryMapper = Mockito.mock(CountryMapper.class);
    private ContinentRepository continentRepository=Mockito.mock(ContinentRepository.class);
    private CountryService countryService = new CountryService(countryRepository,countryMapper,continentRepository);

    @Test
    void shouldCorrectlyReturnCountryByGivenId(){
        //given
        Long id = 1L;
        Country country = new Country();
        country.setName("Polska");
        country.setContinent(null);
        country.setCites(new HashSet<>());

        CountryDto expected = new CountryDto();
        expected.setId(id);
        expected.setName("Polska");
        expected.setCites(null);

        when(countryRepository.findById(id)).thenReturn(Optional.of(country));

        //when
        CountryDto actual = countryService.getById(id);
        //then
        verify(countryRepository).findById(id);
        verify(countryMapper).mapToDto(country);
    }

    @Test
    void shouldThrowExceptionWhenGivenIdIsWrong(){
        assertThatThrownBy(() -> countryService.getById(-1L))
                .isInstanceOf(CountryNotFoundException.class);
    }

    @Test
    void shouldCorrectlyReturnAllCountry(){
        //given
        List<Country> countries = new ArrayList<>();
        Country con = new Country(1L,"Polska",null,null);
        Country con2 = new Country(1L,"Anglia",null,null);
        countries.add(con);
        countries.add(con2);

        when(countryRepository.findAll()).thenReturn(countries);
        //when
        countryService.getAll();
        //then
        verify(countryRepository).findAll();
        verify(countryMapper).mapToDto(con);
    }

    @Test
    void shouldCorrectlyRemoveCountryByGivenId (){
        //given
        Long id = 1L;
        Country con = new Country(id,"Polska",null,null);
        when(countryRepository.findById(id)).thenReturn(Optional.of(con));
        //when
        countryService.removeById(id);
        //then
        verify(countryRepository).delete(con);
    }

    @Test
    void shouldThrowExceptionWhenGivenIdIsWrongWhenTryingToDeleteCountry(){
        assertThatThrownBy(() -> countryService.removeById(-1L))
                .isInstanceOf(CountryNotFoundException.class);
    }
}