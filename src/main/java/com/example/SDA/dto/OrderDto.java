package com.example.SDA.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private Long id;
    private int adultsCount;
    private int childrenCount;
    private TourDto tour;
    private Set<ClientDto> clients ;

}
