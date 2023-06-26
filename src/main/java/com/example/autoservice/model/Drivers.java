package com.example.autoservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Drivers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String passport;
    private String category;
    private LocalDate dateOfBirth;
    private Integer experience;

    private Integer cash;

    @OneToMany
    private List<Cars> cars;


}
