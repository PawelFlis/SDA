package com.example.SDA.dto;

import com.example.SDA.model.Client;
import com.example.SDA.model.Tour;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private Long id;
    private int adultsCount;
    private int childrenCount;
    private Tour tour;
    private Set<Client> clients ;

}
