package com.example.SDA.hotel.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelSimpleDto {
    private Long id;
    private String name;
    private int standard;
    private String note;

}
