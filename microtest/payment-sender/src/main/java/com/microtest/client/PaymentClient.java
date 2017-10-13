package com.microtest.client;

import com.microtest.domain.Payment;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "payment-sender")
public interface PaymentClient {

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    Payment getPayments();

}
