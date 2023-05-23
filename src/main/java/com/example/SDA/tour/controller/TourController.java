package com.example.SDA.tour.controller;

import com.example.SDA.hotel.dto.HotelDto;
import com.example.SDA.hotel.dto.HotelRequestDto;
import com.example.SDA.tour.dto.TourDto;
import com.example.SDA.tour.dto.TourRequestDto;
import com.example.SDA.tour.dto.TourSimpleDto;
import com.example.SDA.tour.enums.TourType;
import com.example.SDA.tour.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tours")
public class TourController {

    private final TourService tourService;

    @GetMapping("/all")
    public List<TourDto> getAllTours(){
        return tourService.getAll();
    }

    @GetMapping("/promoted")
    public List<TourDto> getPromotedTours(){
        return tourService.findPromotedTours();
    }

    @GetMapping("/all/{type}")
    public List<TourDto> findToursByType(@PathVariable("type") TourType type){
        return tourService.findToursByType(type);
    }

    @GetMapping("/LastMinute")
    public List<TourDto> findToursLastMinute(){
        return tourService.findToursLastMinute();
    }

    @GetMapping("/LastMinute/{type}")
    public List<TourDto> findToursLastMinutebyType(@PathVariable("type") TourType type){
        return tourService.findToursLastMinuteByType(type);
    }
    @PostMapping("/add")
    public TourSimpleDto addTour(@RequestBody TourRequestDto tourRequest){
        return tourService.add(tourRequest);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteTour(@PathVariable("id") Long id) {
        tourService.remove(id);
    }

    @PutMapping("/update/{id}")
    public TourDto updateTour(@PathVariable("id") Long tourId,@RequestBody TourRequestDto tourRequest) {
        return tourService.update(tourRequest,tourId);
    }

    @GetMapping("/{id}")
    public TourDto getTour(@PathVariable("id") Long tourId) {
        return tourService.getById(tourId);
    }
}
