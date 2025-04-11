package com.example.orm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "patcient")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patcients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private int phone;
    private Double fees;

    @ManyToOne
    @JoinColumn(name = "programme_id")
    private Programme programmeID;

    @ManyToOne
    @JoinColumn(name = "therepist_id")
    private Sessions sessionID;

}
