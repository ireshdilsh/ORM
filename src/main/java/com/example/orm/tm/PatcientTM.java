package com.example.orm.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatcientTM {
    private int id;
    private String name;
    private String email;
    private int phone;
    private int programmeId;
    private int sessionId;

public PatcientTM(String name, String email, int phone, int programmeId, int sessionId) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.programmeId = programmeId;
    this.sessionId = sessionId;
}
}
