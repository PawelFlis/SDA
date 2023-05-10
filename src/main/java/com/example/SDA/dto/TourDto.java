package com.example.SDA.dto;

import com.example.SDA.model.Airport;
import com.example.SDA.model.City;
import com.example.SDA.model.Hotel;
import com.example.SDA.model.Order;
import com.example.SDA.model.enums.TourType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
//   private Set<OrderDto> orders =new HashSet<>();
/*
   private Hotel hotel;
    private Airport airportFrom;
    private Airport airportTo;
    private City cityFrom;
    private City cityTo;
*/


}
