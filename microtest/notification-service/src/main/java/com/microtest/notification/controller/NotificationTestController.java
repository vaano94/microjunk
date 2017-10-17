package com.microtest.notification.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationTestController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getTestString() {
        return "Hello notification service!";
    }


}