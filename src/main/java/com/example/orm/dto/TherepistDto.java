package com.example.orm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TherepistDto {
    private int id;
    private String name;
    private String email;
    private int phone;

    public TherepistDto(String name, String email, int phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public TherepistDto(int id) {
        this.id = id;
    }

    public TherepistDto(String name2) {
        //TODO Auto-generated constructor stub
    }
}
