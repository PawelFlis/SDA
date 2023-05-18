package com.example.SDA.continent;

import com.example.SDA.country.Country;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany( mappedBy = "continent") //cascade = CascadeType.ALL,
    private Set<Country> countries = new HashSet<>();
}
