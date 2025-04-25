package me.ramone.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${notification-type:email}")
    private String notificationType;

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

    // OrderService Bean
    @Bean
    public OrderService orderService(){
       if(paymentGateway.equals("stripe")){
           return new OrderService(stripe());
       } else{
           return new OrderService(paypal());
       }
    }

    // Notification Beans
    @Bean
    public NotificationService email(){
        if(notificationType.equals("email")){
            return new EmailNotificationService();
        }else {
            return new SMSNotificationService();
        }
    }
}
