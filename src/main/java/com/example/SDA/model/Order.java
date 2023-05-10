package com.example.SDA.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name="Orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adults_count",nullable = false)
    private int adultsCount;

    @Column(name = "children_count")
    private int childrenCount;

    @ManyToOne
    private Tour tour;

    @ManyToMany(mappedBy = "orders")
    private Set<Client> clients = new HashSet<>();
}
