package com.microtest.notification.service;

import com.microtest.notification.domain.Method;
import com.microtest.notification.domain.NotificationLog;
import com.microtest.notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationServiceImpl {

    private NotificationRepository repository;

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
