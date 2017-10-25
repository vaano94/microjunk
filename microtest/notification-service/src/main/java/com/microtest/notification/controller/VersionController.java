package com.microtest.notification.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public String getTestString() {
        return "getting version";
    }


}