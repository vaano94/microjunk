package com.microtest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getTestString() {
        return "Hello world!";
    }
}
