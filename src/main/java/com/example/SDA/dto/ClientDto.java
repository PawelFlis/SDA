package com.example.SDA.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private String phone;

}
