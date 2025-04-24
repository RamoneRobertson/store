package me.ramone.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class AppConfig {

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
        return new OrderService(stripe());
    }
}
