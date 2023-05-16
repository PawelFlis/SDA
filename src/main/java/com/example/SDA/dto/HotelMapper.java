package com.example.SDA.dto;

import com.example.SDA.model.Hotel;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class HotelMapper {

    public static HotelDto mapHotelToDto(Hotel hotel) {
        return HotelDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .standard(hotel.getStandard())
                .note(hotel.getNote())
                .build();
    }

    public static Set<HotelDto> mapHotelsToDto(Set<Hotel> hotels) {
        return hotels.stream().map(HotelMapper::mapHotelToDto).collect(Collectors.toSet());
    }
}
