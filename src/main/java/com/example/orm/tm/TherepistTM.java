package com.example.orm.tm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TherepistTM {
    private int id;
    private String name;
    private String email;
    private int phone;
  
    public TherepistTM(String name) {
        this.name = name;
    }
    
}
