package me.ramone.store;

// Bean created in AppConfig.java
public class PayPalPaymentService implements PaymentService{
    @Override
    public void processPayment(double amount) {
        System.out.println("PayPal Payment: " + amount);
    }
}
