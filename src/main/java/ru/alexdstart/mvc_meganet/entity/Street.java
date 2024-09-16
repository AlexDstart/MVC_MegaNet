package ru.alexdstart.mvc_meganet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String streetName;


    @ManyToMany(mappedBy = "streetsList")
    private Set<City> citySet;
}
