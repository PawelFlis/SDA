package com.example.SDA.dto;

import com.example.SDA.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.SDA.dto.TourMapper.mapTourToDto;


@Component
//@RequiredArgsConstructor
public class OrderMapper {

   // private final TourMapper tourMapper;

    //private  ClientMapper clientMapper;
    public static OrderDto mapOrderToDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .adultsCount(order.getAdultsCount())
                .childrenCount(order.getChildrenCount())
                .tour(mapTourToDto(order.getTour()))
                .clients(ClientMapper.mapClientsToDto(order.getClients()))
                .build();
    }



    public static Set<OrderDto> mapOrdersToDto(Set<Order> orders) {
        return orders.stream().map(OrderMapper::mapOrderToDto).collect(Collectors.toSet());
    }
}
