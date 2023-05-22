package com.example.SDA.order;

import com.example.SDA.client.Client;
import com.example.SDA.tour.Tour;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name="Orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    private Client client;
}
