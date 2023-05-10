package com.example.SDA.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @OneToMany(mappedBy = "airportFrom")
    private Set<Tour> toursFrom = new HashSet<>();

    @OneToMany(mappedBy = "airportTo")
    private Set<Tour> toursTo = new HashSet<>();
}
