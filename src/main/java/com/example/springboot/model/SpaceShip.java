package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "space_ship")
@Data

@NoArgsConstructor
public class SpaceShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String series;
    private String origin;

    public SpaceShip(String name, String series, String origin) {
        this.name = name;
        this.series = series;
        this.origin = origin;
    }
}
