package com.example.SDA.order.dto;

import com.example.SDA.client.dto.ClientSimpleDto;
import com.example.SDA.tour.dto.TourSimpleDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderSimpleDto {

    private Long id;
    private int adultsCount;
    private int childrenCount;
    private TourSimpleDto tour;
    private ClientSimpleDto client ;
}
