package com.example.SDA.hotel.mapper;

import com.example.SDA.city.mapper.CityMapper;
import com.example.SDA.hotel.dto.HotelDto;
import com.example.SDA.hotel.Hotel;
import com.example.SDA.hotel.dto.HotelRequestDto;
import com.example.SDA.hotel.dto.HotelSimpleDto;
import com.example.SDA.tour.mapper.TourMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {
    private final CityMapper cityMapper;
    private final TourMapper tourMapper;

    public HotelMapper(@Lazy CityMapper cityMapper, TourMapper tourMapper) {
        this.cityMapper = cityMapper;
        this.tourMapper = tourMapper;
    }

    public HotelDto mapToDto(Hotel hotel) {
        return HotelDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .standard(hotel.getStandard())
                .note(hotel.getNote())
                .city(cityMapper.mapToSimpleDto(hotel.getCity()))
                .tours(hotel.getTours().stream().map(tourMapper::mapToSimpleDto).toList())
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

    public Hotel mapToEntity(HotelRequestDto request){
        return new Hotel(request.name(), request.standard(), request.note());
    }
}
