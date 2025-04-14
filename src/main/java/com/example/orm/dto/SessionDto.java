package com.example.orm.dto;

import com.example.orm.entity.Therepists;
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
    private int therepistId;
public SessionDto(String name, int start, int end, int therepistId) {
    this.name = name;
    this.start = start;
    this.end = end;
    this.therepistId = therepistId;
}
}
