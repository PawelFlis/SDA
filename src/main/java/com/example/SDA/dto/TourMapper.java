package com.example.SDA.dto;

import com.example.SDA.model.Tour;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TourMapper {

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
                .build();
    }



    public static Set<TourDto> mapToursToDto(Set<Tour> tours) {
        return tours.stream().map(TourMapper::mapTourToDto).collect(Collectors.toSet());
    }

}
