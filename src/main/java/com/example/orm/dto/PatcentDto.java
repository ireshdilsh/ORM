package com.example.orm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatcentDto {
    private int id;
    private String name;
    private String email;
    private int phone;
    private int programmeId;
    private int sessionId;

public PatcentDto(String name, String email, int phone, int programmeId, int sessionId) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.programmeId = programmeId;
    this.sessionId = sessionId;
}
}
