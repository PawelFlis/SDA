package com.example.SDA.order.mapper;

import com.example.SDA.client.mapper.ClientMapper;
import com.example.SDA.order.Order;
import com.example.SDA.order.dto.OrderDto;
import com.example.SDA.order.dto.OrderSimpleDto;
import com.example.SDA.tour.mapper.TourMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ClientMapper clientMapper;
    private final TourMapper tourMapper;

    public  OrderDto mapToDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .adultsCount(order.getAdultsCount())
                .childrenCount(order.getChildrenCount())
                .tour(tourMapper.mapToSimpleDto(order.getTour()))
                .client(clientMapper.mapToSimpleDto(order.getClient()))
                .build();
    }

    public OrderSimpleDto mapToSimpleDto(Order order){
        return OrderSimpleDto.builder()
                .id(order.getId())
                .adultsCount(order.getAdultsCount())
                .childrenCount(order.getChildrenCount())
                .tour(tourMapper.mapToSimpleDto(order.getTour()))
                .client(clientMapper.mapToSimpleDto(order.getClient()))
                .build();
    }

}
