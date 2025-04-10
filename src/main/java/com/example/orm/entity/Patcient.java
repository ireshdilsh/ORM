package com.example.orm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "patcient")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patcient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String email;
    private String address;
    private int phone;

    // Methana thwa gahanna thiyeno mokada foreign key ena ewa thiyenawa
}
