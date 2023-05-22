package com.example.SDA.order.dto;

public record OrderRequestDto(int adultsCount, int childrenCount, Long tourId, Long clientId) {
}
