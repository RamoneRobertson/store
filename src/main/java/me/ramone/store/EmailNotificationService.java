package me.ramone.store;

import org.springframework.beans.factory.annotation.Value;

// Bean created in AppConfig.java
public class EmailNotificationService implements NotificationService {
    @Value("${mail.host}")
    private String host;

    @Value("${mail.port}")
    private String port;

    @Override
    public void send(String message, String recipientEmail){
        System.out.println("👤 Recipient: " + recipientEmail);
        System.out.println("✉️ Message: " + message);
        System.out.println("Host: " + host);
        System.out.println("Port: " + port);
    }
}
