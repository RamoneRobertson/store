package me.ramone.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
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
    // Changed the Bean scope to prototype. Protoype will create a new bean every time it is called.
    //By default, Spring will create a single instance of the bean. This is called Singleton scope.
//    @Scope("prototype")
    public OrderService orderService(){
       if(paymentGateway.equals("stripe")){
           return new OrderService(stripe());
       } else{
           return new OrderService(paypal());
       }
    }
}
