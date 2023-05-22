package com.example.SDA.hotel.controller;

import com.example.SDA.hotel.dto.HotelDto;
import com.example.SDA.hotel.dto.HotelRequestDto;
import com.example.SDA.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;

    @GetMapping("/all")
    public List<HotelDto> getAllHotels(){
        return hotelService.getAll();
    }

    @PostMapping("/add")
    public HotelDto addHotel(@RequestBody HotelRequestDto hotelRequest, @RequestParam Long cityId){
        return hotelService.add(hotelRequest, cityId);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteHotel(@PathVariable("id") Long id) {
        hotelService.remove(id);
    }

    @PutMapping("/update/{id}")
    public HotelDto updateHotel(@PathVariable("id") Long hotelId,@RequestBody HotelRequestDto hotelRequest) {
        return hotelService.update(hotelRequest,hotelId);
    }

    @GetMapping("/{id}")
    public HotelDto getHotel(@PathVariable("id") Long hotelId) {
        return hotelService.getById(hotelId);
    }
}
