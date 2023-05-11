package com.example.SDA.dto;

import com.example.SDA.model.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.SDA.dto.CityMapper.mapCityToDto;

@Component
//@RequiredArgsConstructor
public class HotelMapper {

    //private final CityMapper cityMapper;
    public static HotelDto mapHotelToDto(Hotel hotel) {
        return HotelDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .standard(hotel.getStandard())
                .note(hotel.getNote())
                .city(mapCityToDto(hotel.getCity()))
                .build();
    }

    public static Set<HotelDto> mapHotelsToDto(Set<Hotel> hotels) {
        return hotels.stream().map(HotelMapper::mapHotelToDto).collect(Collectors.toSet());
    }
}
