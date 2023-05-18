package com.example.SDA.order.dto;

import com.example.SDA.client.dto.ClientDto;
import com.example.SDA.client.dto.ClientSimpleDto;
import com.example.SDA.tour.dto.TourDto;
import com.example.SDA.tour.dto.TourSimpleDto;
import lombok.*;

import java.util.List;
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
    private TourSimpleDto tour;
    private List<ClientSimpleDto> clients ;

}
