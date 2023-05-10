package com.example.SDA.dto;

import com.example.SDA.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDto mapToDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .adultsCount(order.getAdultsCount())
                .childrenCount(order.getChildrenCount())
                .tour(order.getTour())
                .clients(order.getClients())
                .build();
    }

}
