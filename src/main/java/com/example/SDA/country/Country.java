package com.example.SDA.country;

import com.example.SDA.city.City;
import com.example.SDA.continent.Continent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Continent continent;

    @OneToMany( mappedBy = "country")
    private Set<City> cites = new HashSet<>();
}
