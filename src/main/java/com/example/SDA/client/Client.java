package com.example.SDA.client;

import com.example.SDA.order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name="last_name",nullable = false)
    private String lastName;

    private LocalDate birthday;

    @Email
    private String email;

    private String phone;

    @ManyToMany
    @JoinTable(name="client_order",
    joinColumns = @JoinColumn(name="client_id"),
    inverseJoinColumns = @JoinColumn(name="order_id"))
    private Set<Order> orders = new HashSet<>();

    public Client(String firstName, String lastName, LocalDate birthday, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
    }
}
