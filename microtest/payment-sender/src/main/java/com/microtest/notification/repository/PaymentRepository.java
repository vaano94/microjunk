package com.microtest.notification.repository;

import com.microtest.notification.domain.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by john on 10/7/17.
 */
@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

    Payment findByTransactionTime(Date date);

    Payment findById(Long id);

}
