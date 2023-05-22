package com.example.SDA.client.service;

import com.example.SDA.client.Client;
import com.example.SDA.client.dto.ClientDto;
import com.example.SDA.client.dto.ClientRequestDto;
import com.example.SDA.client.exception.ClientNotFoundException;
import com.example.SDA.client.mapper.ClientMapper;
import com.example.SDA.client.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ClientDto> getAll(){
        return clientRepository.findAll().stream().map(clientMapper::mapToDto).toList();
    }

    public ClientDto getById(Long id){
        return clientMapper.mapToDto(clientRepository.findById(id).orElseThrow(()->new ClientNotFoundException(id)));
    }

    public void remove(Long id) {
        clientRepository.deleteById(id);
    }

    @Transactional
    public ClientDto update(ClientRequestDto request, Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(()->new ClientNotFoundException(clientId));
        client.setFirstName(request.getFirstName());
        client.setLastName(request.getLastName());
        client.setBirthday(request.getBirthday());
        client.setEmail(request.getEmail());
        client.setPhone(request.getPhone());
        return clientMapper.mapToDto(client);
    }
}
