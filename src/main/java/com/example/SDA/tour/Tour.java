package com.example.SDA.tour;

import com.example.SDA.airport.Airport;
import com.example.SDA.city.City;
import com.example.SDA.hotel.Hotel;
import com.example.SDA.hotel.enums.TourType;
import com.example.SDA.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date_from",nullable = false)
    private LocalDate dateFrom;

    @Column(name="date_to",nullable = false)
    private LocalDate dateTo;

    @Column(nullable = false)
    private int days;

    @Enumerated(EnumType.STRING)
    private TourType type;

    @Column(name="adult_cost",nullable = false)
    private BigDecimal adultCost;

    @Column(name="child_cost",nullable = false)
    private BigDecimal childCost;

    @Column(name="adult_capacity",nullable = false)
    private int adultCapacity;

    @Column(name="child_capacity",nullable = false)
    private int childCapacity;

    @Column(name="is_special")
    private boolean isSpecial;

    @OneToMany( mappedBy = "tour")
    private Set<Order> orders =new HashSet<>();

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    Airport airportFrom;

    @ManyToOne Airport airportTo;

    @ManyToOne
    City cityFrom;

    @ManyToOne City cityTo;

}
