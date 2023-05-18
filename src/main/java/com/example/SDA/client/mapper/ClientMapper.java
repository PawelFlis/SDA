package com.example.SDA.client.mapper;

import com.example.SDA.client.Client;
import com.example.SDA.client.dto.ClientDto;
import com.example.SDA.client.dto.ClientRequestDto;
import com.example.SDA.client.dto.ClientSimpleDto;
import com.example.SDA.order.Order;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    public ClientDto mapToDto(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .birthday(client.getBirthday())
                .email(client.getEmail())
                .phone(client.getPhone())
                .orders(client.getOrders().stream().map(Order::getId).toList())
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
