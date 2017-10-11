package com.microtest;

import com.microtest.service.PaymentSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private PaymentSenderService paymentSenderService;

    @Autowired
    public PaymentController(PaymentSenderService paymentSenderService) {
        this.paymentSenderService = paymentSenderService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/proceed_payment")
    public ResponseEntity<String> proceedPayment(@RequestParam("id") Long id , @RequestParam("accountNumber") int accountNumber, @RequestParam("amount") Long amount) {
        paymentSenderService.proceedPayment(id, accountNumber, amount);
        return new ResponseEntity<String>("Payment with accountnum : " + accountNumber + " and id: " + id + " has been persisted", null, HttpStatus.OK);
    }



}
