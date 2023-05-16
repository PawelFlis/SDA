package com.example.SDA.dto;

import com.example.SDA.model.enums.TourType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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


}
