package com.example.SDA.client.mapper;

import com.example.SDA.client.Client;
import com.example.SDA.client.dto.ClientDto;
import com.example.SDA.client.dto.ClientRequestDto;
import com.example.SDA.client.dto.ClientSimpleDto;
import com.example.SDA.order.Order;
import com.example.SDA.order.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClientMapper {
    private final OrderMapper orderMapper;

    public ClientMapper(@Lazy OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public ClientDto mapToDto(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .birthday(client.getBirthday())
                .email(client.getEmail())
                .phone(client.getPhone())
                .orders(client.getOrders().stream().map(orderMapper::mapToSimpleDto).toList())
                .build();
    }


    public Client mapToEntity(ClientRequestDto request) {
        return new Client(request.getFirstName(),request.getLastName(),request.getBirthday(),request.getEmail(),request.getPhone());
    }

    public ClientSimpleDto mapToSimpleDto(Client client) {
        return ClientSimpleDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .birthday(client.getBirthday())
                .email(client.getEmail())
                .phone(client.getPhone())
                .build();
    }
}
