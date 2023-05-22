package com.example.SDA.order.service;

import com.example.SDA.client.Client;
import com.example.SDA.client.exception.ClientNotFoundException;
import com.example.SDA.client.repository.ClientRepository;
import com.example.SDA.order.Order;
import com.example.SDA.order.dto.OrderDto;
import com.example.SDA.order.dto.OrderRequestDto;
import com.example.SDA.order.exception.OrderNotFoundException;
import com.example.SDA.order.mapper.OrderMapper;
import com.example.SDA.order.repository.OrderRepository;
import com.example.SDA.tour.Tour;
import com.example.SDA.tour.exception.TourNotFoundException;
import com.example.SDA.tour.repository.TourRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ClientRepository clientRepository;
    private final TourRepository tourRepository;


    public List<OrderDto> getAll(){
        return orderRepository.findAll().stream().map(orderMapper::mapToDto).toList();
    }

    public OrderDto getById(Long id){
        return orderMapper.mapToDto(orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException(id)));
    }

    @Transactional
    public OrderDto add(OrderRequestDto orderRequest){
        Client client=clientRepository.findById(orderRequest.clientId()).orElseThrow(()->new ClientNotFoundException(orderRequest.clientId()));
        Tour tour=tourRepository.findById(orderRequest.tourId()).orElseThrow(()->new TourNotFoundException(orderRequest.tourId()));
        Order order = new Order();
        order.setClient(client);
        order.setTour(tour);
        order.setAdultsCount(orderRequest.adultsCount());
        order.setChildrenCount(orderRequest.childrenCount());
        orderRepository.save(order);
        return orderMapper.mapToDto(order);
    }

    @Transactional
    public OrderDto update(OrderRequestDto orderRequest, Long orderId){
        Client client=clientRepository.findById(orderRequest.clientId()).orElseThrow(()->new ClientNotFoundException(orderRequest.clientId()));
        Tour tour=tourRepository.findById(orderRequest.tourId()).orElseThrow(()->new TourNotFoundException(orderRequest.tourId()));
        Order order = orderRepository.findById(orderId).orElseThrow(()->new OrderNotFoundException(orderId));
        order.setClient(client);
        order.setTour(tour);
        order.setAdultsCount(orderRequest.adultsCount());
        order.setChildrenCount(orderRequest.childrenCount());
        return orderMapper.mapToDto(order);
    }

    public void remove(Long id){
        orderRepository.deleteById(id);
    }
}
