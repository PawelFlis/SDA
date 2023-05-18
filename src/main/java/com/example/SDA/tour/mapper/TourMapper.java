package com.example.SDA.tour.mapper;

import com.example.SDA.tour.Tour;
import com.example.SDA.tour.dto.TourDto;
import com.example.SDA.tour.dto.TourSimpleDto;
import org.springframework.stereotype.Component;

@Component
public class TourMapper {

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
                .build();
    }

}
