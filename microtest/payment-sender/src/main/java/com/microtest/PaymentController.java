package com.microtest;

import com.microtest.notification.client.NotificationClient;
import com.microtest.notification.domain.Payment;
import com.microtest.notification.service.PaymentSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    private PaymentSenderService paymentSenderService;

    private NotificationClient notificationClient;

    @Autowired
    public PaymentController(PaymentSenderService paymentSenderService, NotificationClient notificationClient) {
        this.paymentSenderService = paymentSenderService;
        this.notificationClient = notificationClient;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/proceed_payment")
    public ResponseEntity<String> proceedPayment(@RequestParam("id") Long id , @RequestParam("accountNumber") int accountNumber, @RequestParam("amount") Long amount) {
        paymentSenderService.proceedPayment(id, accountNumber, amount);
        return new ResponseEntity<>("Payment with accountnum : " + accountNumber + " and id: " + id + " has been persisted", null, HttpStatus.OK);
    }

    public List<Payment> getPayments() {
        return paymentSenderService.getPayments();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/version")
    public String version() {
        String version = notificationClient.version();
        return version;
    }

}
