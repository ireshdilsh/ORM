package com.example.orm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessionDto {
    private int id;
    private String name;
    private int start;
    private int end;
    private TherepistDto therepistId;
    
    public SessionDto(String name, int start, int end, TherepistDto therepistId) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.therepistId = therepistId;
    }
}
