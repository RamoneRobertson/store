package me.ramone.store;

public class OrderService {

    private PaymentService paymentService;

    // Constructor Injection
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(){
        paymentService.processPayment(10);
    }

    // Setter Injection
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
