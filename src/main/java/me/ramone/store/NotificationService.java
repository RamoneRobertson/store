package me.ramone.store;

import org.springframework.stereotype.Service;

@Service
public interface NotificationService {
    void send(String message, String recipientEmail);
}
