package com.example.SDA.dto;

import com.example.SDA.model.Order;
import com.example.SDA.model.Tour;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TourMapper {

    private final OrderMapper orderMapper;
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
             //   .orders(mapToOrderDto(tour.getOrders()))
/*                .hotel(tour.getHotel())
                .airportFrom(tour.getAirportFrom())
                .airportTo(tour.getAirportTo())
                .cityFrom(tour.getCityFrom())
                .cityTo(tour.getCityTo())*/
                .build();
    }

    private Set<OrderDto> mapToOrderDto (Set<Order> orders) {
        return orders.stream().map(orderMapper::mapToDto).collect(Collectors.toSet());
    }

}
