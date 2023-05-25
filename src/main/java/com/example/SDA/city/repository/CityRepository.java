package com.example.SDA.city.repository;

import com.example.SDA.city.City;
import com.example.SDA.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findCityByName(String cityName);

}
