package com.example.SDA.service;

import com.example.SDA.dto.TourDto;
import com.example.SDA.dto.TourMapper;
import com.example.SDA.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.SDA.dto.TourMapper.mapToursToDto;

@Service
@RequiredArgsConstructor
public class TourService {


    private final TourRepository tourRepository;
    private final TourMapper tourMapper;

    public List<TourDto> getAllTours(){
        //return tourRepository.findAll().stream().map(tourMapper::mapToDto).toList();
        return mapToursToDto(tourRepository.findAll().stream().collect(Collectors.toSet())).stream().toList();
    }


}
