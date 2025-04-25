package me.ramone.store;

public class SMSNotificationService implements NotificationService {
    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("A confirmation text sent to your mobile phone");
    }
}
