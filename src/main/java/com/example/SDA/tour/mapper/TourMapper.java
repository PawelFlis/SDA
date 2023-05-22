package com.example.SDA.tour.mapper;

import com.example.SDA.airport.mapper.AirportMapper;
import com.example.SDA.city.mapper.CityMapper;
import com.example.SDA.hotel.mapper.HotelMapper;
import com.example.SDA.order.mapper.OrderMapper;
import com.example.SDA.tour.Tour;
import com.example.SDA.tour.dto.TourDto;
import com.example.SDA.tour.dto.TourSimpleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TourMapper {
    private final HotelMapper hotelMapper;
    private final CityMapper cityMapper;
    private final OrderMapper orderMapper;
    private final AirportMapper airportMapper;

    public TourMapper(@Lazy HotelMapper hotelMapper
            , @Lazy CityMapper cityMapper
            , @Lazy OrderMapper orderMapper
            , @Lazy AirportMapper airportMapper) {
        this.hotelMapper = hotelMapper;
        this.cityMapper = cityMapper;
        this.orderMapper = orderMapper;
        this.airportMapper = airportMapper;
    }

    public TourDto mapToDto(Tour tour) {
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
                .orders(tour.getOrders().stream().map(orderMapper::mapToSimpleDto).toList())
                .hotel(hotelMapper.mapToSimpleDto(tour.getHotel()))
                .airportFrom(airportMapper.mapToSimpleDto(tour.getAirportFrom()))
                .airportTo(airportMapper.mapToSimpleDto(tour.getAirportTo()))
                .cityFrom(cityMapper.mapToSimpleDto(tour.getCityFrom()))
                .cityTo(cityMapper.mapToSimpleDto(tour.getCityTo()))
                .build();
    }

    public TourSimpleDto mapToSimpleDto(Tour tour) {
        return TourSimpleDto.builder()
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
                .hotel(hotelMapper.mapToSimpleDto(tour.getHotel()))
                .cityTo(cityMapper.mapToSimpleDto(tour.getCityTo()))
                .build();
    }

}
