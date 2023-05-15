package com.example.SDA.dto;

import com.example.SDA.model.Tour;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.SDA.dto.AirportMapper.mapAirportToDto;
import static com.example.SDA.dto.CityMapper.mapCityToDto;
import static com.example.SDA.dto.HotelMapper.mapHotelToDto;
import static com.example.SDA.dto.OrderMapper.mapOrdersToDto;

@Component
//@RequiredArgsConstructor
public class TourMapper {

    //private final OrderMapper orderMapper;
    //private final HotelMapper hotelMapper;
    //private final AirportMapper airportMapper;
    //private final CityMapper cityMapper;

    public static TourDto mapTourToDto(Tour tour) {
        return TourDto.builder()
                .id(tour.getId())
                .dateFrom(tour.getDateFrom())
                .dateTo(tour.getDateTo())
                .days(tour.getDays())
                .type(tour.getType())
                .adultCost(tour.getAdultCost())
                .childCost(tour.getChildCost())
                .adultCapacity(tour.getAdultCapacity())
                .childCapacity(tour.getChildCapacity())
                .isSpecial(tour.isSpecial())
               .orders(mapOrdersToDto(tour.getOrders()))
          //      .hotel(mapHotelToDto(tour.getHotel()))
         //       .airportFrom(mapAirportToDto(tour.getAirportFrom()))
         //       .airportTo(mapAirportToDto(tour.getAirportTo()))
          //      .cityFrom(mapCityToDto(tour.getCityFrom()))
         //       .cityTo(mapCityToDto(tour.getCityTo()))
                .build();
    }



    public static Set<TourDto> mapToursToDto(Set<Tour> tours) {
        return tours.stream().map(TourMapper::mapTourToDto).collect(Collectors.toSet());
    }

}
