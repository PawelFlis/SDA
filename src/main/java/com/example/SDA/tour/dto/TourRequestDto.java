package com.example.SDA.tour.dto;

import com.example.SDA.airport.dto.AirportSimpleDto;
import com.example.SDA.city.dto.CitySimpleDto;
import com.example.SDA.hotel.dto.HotelSimpleDto;
import com.example.SDA.hotel.enums.TourType;
import com.example.SDA.order.dto.OrderSimpleDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record TourRequestDto(
        @JsonFormat(pattern="yyyy-MM-dd") LocalDate dateFrom,
        @JsonFormat(pattern="yyyy-MM-dd") LocalDate dateTo,
        int days,
        TourType type,
        BigDecimal adultCost,
        BigDecimal childCost,
        int adultCapacity,
        int childCapacity,
        boolean isSpecial,
        //List<OrderSimpleDto>orders,
        Long hotelId,
        Long airportFromId,
        Long airportToId,
        Long cityFromId,
        Long cityToId
) {
}
