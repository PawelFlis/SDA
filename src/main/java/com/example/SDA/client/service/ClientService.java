package com.example.SDA.client.service;

import com.example.SDA.client.Client;
import com.example.SDA.client.dto.ClientDto;
import com.example.SDA.client.dto.ClientRequestDto;
import com.example.SDA.client.mapper.ClientMapper;
import com.example.SDA.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientDto add(ClientRequestDto request) {
        Client client = clientMapper.mapToEntity(request);
        clientRepository.save(client);
        return clientMapper.mapToDto(client);
    }
}
