package com.example.SDA.city;

import com.example.SDA.airport.Airport;
import com.example.SDA.country.Country;
import com.example.SDA.hotel.Hotel;
import com.example.SDA.tour.Tour;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "city")
    private Set<Airport> airports = new HashSet<>();

    @OneToMany(mappedBy = "city")
    private Set<Hotel> hotels = new HashSet<>();

    @OneToMany(mappedBy = "cityFrom")
    private  Set<Tour> toursFrom = new HashSet<>();

    @OneToMany(mappedBy = "cityTo")
    private  Set<Tour> toursTo = new HashSet<>();

}
