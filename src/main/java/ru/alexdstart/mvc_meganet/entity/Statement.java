package ru.alexdstart.mvc_meganet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String city;
    private String name;
    private String street;
    private String homeNumber;
    private String mobileNumber;
    private String description;
    private LocalDate dateCreate;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tariff tariff;
}
