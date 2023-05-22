package com.example.SDA.tour.service;

import com.example.SDA.airport.Airport;
import com.example.SDA.airport.exception.AirportNotFoundException;
import com.example.SDA.airport.repository.AirportRepository;
import com.example.SDA.city.City;
import com.example.SDA.city.exception.CityNotFoundException;
import com.example.SDA.city.repository.CityRepository;
import com.example.SDA.hotel.Hotel;
import com.example.SDA.hotel.exception.HotelNotFoundException;
import com.example.SDA.hotel.mapper.HotelMapper;
import com.example.SDA.hotel.repository.HotelRepository;
import com.example.SDA.order.dto.OrderDto;
import com.example.SDA.order.dto.OrderRequestDto;
import com.example.SDA.tour.Tour;
import com.example.SDA.tour.dto.TourDto;
import com.example.SDA.tour.dto.TourRequestDto;
import com.example.SDA.tour.dto.TourSimpleDto;
import com.example.SDA.tour.exception.TourNotFoundException;
import com.example.SDA.tour.mapper.TourMapper;
import com.example.SDA.tour.repository.TourRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TourService {
    private final TourRepository tourRepository;
    private final TourMapper tourMapper;
    private final HotelRepository hotelRepository;
    private final AirportRepository airportRepository;
    private final CityRepository cityRepository;

    public List<TourDto> getAll(){
        return tourRepository.findAll().stream().map(tourMapper::mapToDto).toList();
    }

    public TourDto getById(Long id){
        return tourMapper.mapToDto(tourRepository.findById(id).orElseThrow(()->new TourNotFoundException(id)));
    }

    public void remove(Long id){
        tourRepository.deleteById(id);
    }

    @Transactional
    public TourSimpleDto add(TourRequestDto tourRequest) {
        Hotel hotel = hotelRepository.findById(tourRequest.hotelId()).orElseThrow(()->new HotelNotFoundException(tourRequest.hotelId()));
        Airport airportFrom = airportRepository.findById(tourRequest.airportFromId()).orElseThrow(()->new AirportNotFoundException(tourRequest.airportFromId()));
        Airport airportTo = airportRepository.findById(tourRequest.airportToId()).orElseThrow(()->new AirportNotFoundException(tourRequest.airportToId()));
        City cityFrom = cityRepository.findById(tourRequest.cityFromId()).orElseThrow(()->new CityNotFoundException(tourRequest.cityFromId()));
        City cityTo = cityRepository.findById(tourRequest.cityToId()).orElseThrow(()->new CityNotFoundException(tourRequest.cityToId()));
        Tour tour = Tour.builder()
                .dateFrom(tourRequest.dateFrom())
                .dateTo(tourRequest.dateTo())
                .days(tourRequest.days())
                .type(tourRequest.type())
                .adultCost(tourRequest.adultCost())
                .childCost(tourRequest.childCost())
                .adultCapacity(tourRequest.adultCapacity())
                .childCapacity(tourRequest.childCapacity())
                .isSpecial(tourRequest.isSpecial())
                .hotel(hotel)
                .airportFrom(airportFrom)
                .airportTo(airportTo)
                .cityFrom(cityFrom)
                .cityTo(cityTo)
                .build();
        tourRepository.save(tour);
        return tourMapper.mapToSimpleDto(tour);
    }

    @Transactional
    public TourDto update(TourRequestDto tourRequest, Long tourId){
        Tour tour = tourRepository.findById(tourId).orElseThrow(()->new TourNotFoundException(tourId));

        return tourMapper.mapToDto(tour);
    }
}
