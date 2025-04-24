package me.ramone.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class AppConfig {
    @Value( "${payment-gateway:stripe}")
    private String paymentGateway;

    // Stripe Payment Service
    @Bean
    public PaymentService stripe(){
        return new StripePaymentService();
    }

    // PayPal Payment Service
    @Bean
    public PaymentService paypal(){
        return new PayPalPaymentService();
    }

    @Bean
    public OrderService orderService(){
       if(paymentGateway.equals("stripe")){
           return new OrderService(stripe());
       } else{
           return new OrderService(paypal());
       }
    }
}
