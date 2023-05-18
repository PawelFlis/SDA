package com.example.SDA.hotel.mapper;

import com.example.SDA.hotel.dto.HotelDto;
import com.example.SDA.hotel.Hotel;
import com.example.SDA.hotel.dto.HotelSimpleDto;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public static HotelDto mapToDto(Hotel hotel) {
        return HotelDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .standard(hotel.getStandard())
                .note(hotel.getNote())
                .build();
    }

    public HotelSimpleDto mapToSimpleDto(Hotel hotel) {
        return HotelSimpleDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .standard(hotel.getStandard())
                .note(hotel.getNote())
                .build();
    }
}
