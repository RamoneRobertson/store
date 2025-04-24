package me.ramone.store;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("emailNotification")
@Primary
public class EmailNotificationService implements NotificationService {

    // NotificationService has one method send, so we must implement this method/Override
    @Override
    public void send(String message){
        System.out.println("Sending email: " + message);
    }
}
