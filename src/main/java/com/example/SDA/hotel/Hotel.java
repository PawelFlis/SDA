package com.example.SDA.hotel;

import com.example.SDA.city.City;
import com.example.SDA.tour.Tour;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Min(1)
    @Max(5)
    private int standard;

    @Column(columnDefinition = "text")
    private String note;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "hotel",orphanRemoval = true)
    private Set<Tour> tours = new HashSet<>();

    public Hotel(String name, int standard, String note) {
        this.name = name;
        this.standard = standard;
        this.note = note;
    }
}
