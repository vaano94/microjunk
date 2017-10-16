package com.microtest.service;

import com.microtest.client.PaymentClient;
import com.microtest.domain.Payment;
import com.microtest.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

    public List<Payment> getPayments() {
        List<Payment> payments = new ArrayList<>();
        for (Payment payment : paymentRepository.findAll()) {
            payments.add(payment);
        }
        return payments;
    }

}
