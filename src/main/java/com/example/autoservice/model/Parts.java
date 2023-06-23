package com.example.autoservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Parts {

    @Id
    private String serialNumber;
    private String namePart;

    @ManyToOne
    private Cars car;
}
