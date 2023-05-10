package com.example.SDA.service;

import com.example.SDA.dto.TourDto;
import com.example.SDA.dto.TourMapper;
import com.example.SDA.model.Tour;
import com.example.SDA.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourService {


    private final TourRepository tourRepository;
    private final TourMapper tourMapper;

    public List<TourDto> getAllTours(){
        return tourRepository.findAll().stream().map(tourMapper::mapToDto).toList();
    }

}
