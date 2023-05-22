package com.example.SDA.continent.service;

import com.example.SDA.continent.Continent;
import com.example.SDA.continent.dto.ContinentDto;
import com.example.SDA.continent.exception.ContinentNotFoundException;
import com.example.SDA.continent.mapper.ContinentMapper;
import com.example.SDA.continent.repository.ContinentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContinentService {

    private final ContinentRepository continentRepository;
    private final ContinentMapper continentMapper;

    public List<ContinentDto> getAll() {
        return continentRepository.findAll().stream().map(continentMapper::mapToDto).toList();
    }

    public ContinentDto getById (Long continentId) {
        Continent continent = continentRepository.findById(continentId).orElseThrow(() -> new ContinentNotFoundException(continentId));
        return continentMapper.mapToDto(continent);
    }
}
