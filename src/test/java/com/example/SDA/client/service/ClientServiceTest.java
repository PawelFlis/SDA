package com.example.SDA.client.service;

import com.example.SDA.client.dto.ClientDto;
import com.example.SDA.client.dto.ClientRequestDto;
import com.example.SDA.client.mapper.ClientMapper;
import com.example.SDA.client.repository.ClientRepository;
import com.example.SDA.order.Order;
import com.example.SDA.order.dto.OrderSimpleDto;
import com.example.SDA.order.mapper.OrderMapper;
import com.example.SDA.tour.mapper.TourMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

/*    private ClientMapper clientMapper = Mockito.mock(ClientMapper.class);
    private ClientRepository repository = Mockito.mock(ClientRepository.class);
    private ClientService service = new ClientService(repository,clientMapper);*/

    @Mock
    private ClientRepository repository;
    @InjectMocks
    private ClientService service;
    @Mock
    private ClientMapper clientMapper;

    @Disabled
    @Test
    void shouldCorrectlyAdNewClient() {
        //given
        //when(repository.save)
        ClientRequestDto clientRequestDto = new ClientRequestDto();
        clientRequestDto.setFirstName("Jan");
        clientRequestDto.setLastName("Nowak");
        clientRequestDto.setBirthday(LocalDate.of(2020,1,1));
        clientRequestDto.setEmail("abc@abc");
        clientRequestDto.setPhone("123132");

        ClientDto expected = new ClientDto();
        expected.setId(1L);
        expected.setFirstName("Jan");
        expected.setLastName("Nowak");
        expected.setBirthday(LocalDate.of(2020,1,1));
        expected.setEmail("abc@abc");
        expected.setPhone("123132");
        expected.setOrders(new ArrayList<OrderSimpleDto>());

        //when
            service.add(clientRequestDto);
            ClientDto result =clientMapper.mapToDto(repository.findById(1L).orElse(null));
        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }


}