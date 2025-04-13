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

@Entity(name = "session")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sessions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int start;
    private int end;

    @ManyToOne
    @JoinColumn(name = "therepist_ID")
    private Therepists therepists;
}
