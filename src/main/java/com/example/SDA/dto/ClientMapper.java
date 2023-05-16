package com.example.SDA.dto;

import com.example.SDA.model.Client;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    public static ClientDto mapClientToDto(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .birthday(client.getBirthday())
                .email(client.getEmail())
                .phone(client.getPhone())
                .build();
    }


    public static Set<ClientDto> mapClientsToDto(Set<Client> clients) {
        return clients.stream().map(ClientMapper::mapClientToDto).collect(Collectors.toSet());
    }
}
