package com.example.autoservice.model;


import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cars {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String vin;
    private String stateNumber;

    private String manufacturer;
    private LocalDate brand;
    private Integer year;

    @ManyToOne
    private Drivers driver;
    @OneToMany
    private List<Parts> parts;
}
