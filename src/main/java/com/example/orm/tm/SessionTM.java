package com.example.orm.tm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SessionTM {
    private int id;
    private String name;
    private int start;
    private int end;
    private int therepistId;
}
