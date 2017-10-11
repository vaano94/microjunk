package com.microtest.service;

import com.microtest.domain.Payment;
import com.microtest.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentSenderService {

    PaymentRepository paymentRepository;

    @Autowired
    public PaymentSenderService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void proceedPayment(Long id , int accountNumber, Long amount) {

        Payment payment = new Payment();
        payment.setId(id);
        payment.setAccountNumber(accountNumber);
        payment.setAmount(amount);
        payment.setTransactionTime(new Date());

        paymentRepository.save(payment);

    }

}
