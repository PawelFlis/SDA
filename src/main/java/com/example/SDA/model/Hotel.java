package com.example.SDA.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int standard;

    @Column(columnDefinition = "text")
    private String note;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "hotel")
    private Set<Tour> tours = new HashSet<>();


}
