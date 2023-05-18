package com.example.SDA.tour.service;

import com.example.SDA.tour.dto.TourDto;
import com.example.SDA.tour.mapper.TourMapper;
import com.example.SDA.tour.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TourService {


    private final TourRepository tourRepository;
    private final TourMapper tourMapper;

    public List<TourDto> getAllTours(){
        //return tourRepository.findAll().stream().map(tourMapper::mapToDto).toList();
        return tourRepository.findAll().stream().map(tourMapper::mapToDto).toList();
    }


}
