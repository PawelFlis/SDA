package com.example.SDA.hotel.service;

import com.example.SDA.city.City;
import com.example.SDA.city.exception.CityNotFoundException;
import com.example.SDA.city.repository.CityRepository;
import com.example.SDA.client.exception.ClientNotFoundException;
import com.example.SDA.hotel.Hotel;
import com.example.SDA.hotel.dto.HotelDto;
import com.example.SDA.hotel.dto.HotelRequestDto;
import com.example.SDA.hotel.exception.HotelNotFoundException;
import com.example.SDA.hotel.mapper.HotelMapper;
import com.example.SDA.hotel.repository.HotelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;
    private final CityRepository cityRepository;

    public List<HotelDto> getAll(){
        return hotelRepository.findAll().stream().map(h->hotelMapper.mapToDto(h)).toList();
    }

    public HotelDto getById(Long id) {
        return hotelMapper.mapToDto(hotelRepository.findById(id).orElseThrow(()->new HotelNotFoundException(id)));
    }

    public HotelDto add(HotelRequestDto request, Long cityId) {
        Hotel hotel = hotelMapper.mapToEntity(request);
        City city = cityRepository.findById(cityId).orElseThrow(()->new CityNotFoundException(cityId));
        hotel.setCity(city);
        hotelRepository.save(hotel);
        return hotelMapper.mapToDto(hotel);
    }

    public void remove(Long id){
        hotelRepository.deleteById(id);
    }

    @Transactional
    public HotelDto update (HotelRequestDto request, Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(()->new ClientNotFoundException(hotelId));
        hotel.setName(request.name());
        hotel.setStandard(request.standard());
        hotel.setNote(request.note());
        return hotelMapper.mapToDto(hotel);
    }

}
