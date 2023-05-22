package com.example.SDA.order.controller;

import com.example.SDA.order.dto.OrderDto;
import com.example.SDA.order.dto.OrderRequestDto;
import com.example.SDA.order.repository.OrderRepository;
import com.example.SDA.order.service.OrderService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/all")
    public List<OrderDto> getAllOrders(){
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable Long id){
        return orderService.getById(id);
    }

    @PutMapping("/update/{id}")
    public OrderDto updateOrder(@RequestBody OrderRequestDto orderRequest,@PathVariable Long id){
        return orderService.update(orderRequest, id);
    }

    @PostMapping("/add")
    public OrderDto addOrder (@RequestBody OrderRequestDto orderRequest) {
        return orderService.add(orderRequest);
    }

    @DeleteMapping("remove/{id}")
    public void remove(@PathVariable("id") Long id) {
        orderService.remove(id);
    }
}
