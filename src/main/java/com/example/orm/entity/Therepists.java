package com.example.orm.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "therepist")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Therepists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private int phone;
    
    public Therepists(String name, String email, int phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
