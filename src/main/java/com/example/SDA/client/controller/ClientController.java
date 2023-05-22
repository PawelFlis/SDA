package com.example.SDA.client.controller;

import com.example.SDA.client.dto.ClientDto;
import com.example.SDA.client.dto.ClientRequestDto;
import com.example.SDA.client.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/add")
    public ClientDto addNewClient(@RequestBody ClientRequestDto clientRequest) {
        return clientService.add(clientRequest);
    }

    @GetMapping("/all")
    public List<ClientDto> getAllClients(){
        return clientService.getAll();
    }

    @PutMapping("/update/{id}")
    public ClientDto updateClient(@PathVariable Long id, @RequestBody ClientRequestDto clientRequest) {
        return clientService.update(clientRequest, id);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.remove(id);
    }

    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable Long id){
        return clientService.getById(id);
    }
}
