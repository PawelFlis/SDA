package com.example.SDA.controller;

import com.example.SDA.dto.TourDto;
import com.example.SDA.model.Tour;
import com.example.SDA.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tours")
public class TourController {

    private final TourService tourService;

    @GetMapping("/all")
    public List<TourDto> getAllTours(){
        return tourService.getAllTours();
    }

}
