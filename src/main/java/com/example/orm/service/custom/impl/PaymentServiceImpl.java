package com.example.orm.service.custom.impl;

import com.example.orm.dao.DaoFactory;
import com.example.orm.dao.custom.PatcientDao;
import com.example.orm.dao.custom.PaymentDao;
import com.example.orm.dto.PaymentDto;
import com.example.orm.entity.Patcients;
import com.example.orm.entity.Payment;
import com.example.orm.service.custom.PaymentService;

public class PaymentServiceImpl implements PaymentService {
    PaymentDao paymentDao = (PaymentDao) DaoFactory.getDaoFactory().getDao(DaoFactory.daoType.PAYMENT);
    PatcientDao patcientDao = (PatcientDao) DaoFactory.getDaoFactory().getDao(DaoFactory.daoType.PATCIENT);

    @Override
    public boolean savePayment(PaymentDto paymentDto) throws Exception{
        Patcients patcients = patcientDao.findByPK(paymentDto.getPatcientId());
        return paymentDao.save(new Payment(
                paymentDto.getId(),
                paymentDto.getAmout(),
                patcients
        ));
    }
}
