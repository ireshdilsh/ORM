package com.example.orm.service.custom;

import java.util.ArrayList;

import com.example.orm.dto.PaymentDto;
import com.example.orm.service.SuperService;

public interface PaymentService extends SuperService {
    boolean savePayment(PaymentDto paymentDto) throws Exception;

    ArrayList<PaymentDto> getAllPayments();

}
