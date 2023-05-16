package com.example.SDA.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelDto {
    private Long id;
    private String name;
    private int standard;
    private String note;

}
