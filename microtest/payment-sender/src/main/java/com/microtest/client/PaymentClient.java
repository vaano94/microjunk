package com.microtest.client;

import com.microtest.domain.Payment;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "payment-sender")
// , url = "http://localhost:9000/payments"
public interface PaymentClient {

    @RequestMapping(method = RequestMethod.GET, value = "/payments")
    List<Payment> getPayments();

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    String version();

}
