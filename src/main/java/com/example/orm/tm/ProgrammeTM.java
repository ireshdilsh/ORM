package com.example.orm.tm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProgrammeTM {
    private int id;
    private String name;
    private String duration;
    private double fees;
    public ProgrammeTM(String name, String duration, double fees) {
        this.name = name;
        this.duration = duration;
        this.fees = fees;
    }
}
