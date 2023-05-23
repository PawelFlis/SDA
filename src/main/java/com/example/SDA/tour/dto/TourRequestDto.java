package com.example.SDA.tour.dto;

import com.example.SDA.tour.enums.TourType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

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
