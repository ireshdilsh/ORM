package com.example.orm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDto {
    private int id;
    private Double amout;
    private int patcientId;

public PaymentDto(Double amout, int patcientId) {
    this.amout = amout;
    this.patcientId = patcientId;
}
}
