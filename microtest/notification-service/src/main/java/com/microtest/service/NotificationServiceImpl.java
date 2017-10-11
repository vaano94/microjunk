package com.microtest.service;

import com.microtest.domain.Method;
import com.microtest.domain.NotificationLog;
import com.microtest.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationServiceImpl {

    NotificationRepository repository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository repository) {
        this.repository = repository;
    }

    public void sendNotification(Method method, String message) {
        System.out.println("Sending message :" + message + " over " + method.name());
        NotificationLog notificationLog = new NotificationLog();
        notificationLog.setMessage("Notifiction saved : " + message);
        notificationLog.setNotificationDate(new Date());
        repository.save(notificationLog);
    }

}
