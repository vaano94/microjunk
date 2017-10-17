package com.microtest.notification.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("notification-service")
public interface NotificationClient {

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    String version();

}
