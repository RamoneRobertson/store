package me.ramone.store;

public class PayPalPaymentService implements PaymentService{
    @Override
    public void processPayment(double amount) {
        System.out.println("PayPal Payment: " + amount);
    }
}
