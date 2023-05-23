package com.example.SDA.tour.dto;

import com.example.SDA.airport.dto.AirportSimpleDto;
import com.example.SDA.city.dto.CitySimpleDto;
import com.example.SDA.hotel.dto.HotelSimpleDto;
import com.example.SDA.tour.enums.TourType;
import com.example.SDA.order.dto.OrderSimpleDto;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TourDto {
    private Long id;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private int days;
    private TourType type;
    private BigDecimal adultCost;
    private BigDecimal childCost;
    private int adultCapacity;
    private int childCapacity;
    private boolean isSpecial;
    private List<OrderSimpleDto> orders;
    private HotelSimpleDto hotel;
    private AirportSimpleDto airportFrom;
    private AirportSimpleDto airportTo;
    private CitySimpleDto cityFrom;
    private CitySimpleDto cityTo;



}
