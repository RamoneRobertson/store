package me.ramone.store;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
public class OrderService {

    private PaymentService paymentService;

    // Constructor Injection
    // @Autowired
    // lets Spring hand your class the tools it needs, instead of your class building those tools itself
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("OrderService created");
    }

    public void placeOrder(){
        paymentService.processPayment(10);
    }

    @PostConstruct // This annotation is used to execute code after the bean is initialized
    // This method is called after the constructor is called
    public void init(){
        System.out.println("OrderService PostConstruct");
    }

    @PreDestroy // This annotation is used to execute code before the bean is destroyed
    public void cleanup(){
        System.out.println("OrderService PreDestroy");
    }

    // Setter Injection
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
