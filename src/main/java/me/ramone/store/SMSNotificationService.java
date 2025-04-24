package me.ramone.store;

import org.springframework.stereotype.Service;

@Service("smsNotification")
public class SMSNotificationService implements NotificationService {

    // Again, to avoid errors, we must implement the method in the Interface send(String message)
    @Override
    public void send(String message){
        System.out.println("Sending text: " + message);
    }
}
