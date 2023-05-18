package com.example.SDA.client.controller;

import com.example.SDA.client.dto.ClientDto;
import com.example.SDA.client.dto.ClientRequestDto;
import com.example.SDA.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/add")
    public ClientDto addNewClient(@RequestBody ClientRequestDto clientRequest) {
        return clientService.add(clientRequest);
    }

}
