package com.example.SDA.country;

import com.example.SDA.city.City;
import com.example.SDA.continent.Continent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Continent continent;

    @OneToMany( mappedBy = "country",orphanRemoval = true)
    private Set<City> cites = new HashSet<>();
}
