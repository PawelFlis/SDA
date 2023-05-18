package com.example.SDA.airport;

import com.example.SDA.city.City;
import com.example.SDA.tour.Tour;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "airportFrom",orphanRemoval = true)
    private Set<Tour> toursFrom = new HashSet<>();

    @OneToMany(mappedBy = "airportTo",orphanRemoval = true)
    private Set<Tour> toursTo = new HashSet<>();
}
