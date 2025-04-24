package me.ramone.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

        var orderService = context.getBean(OrderService.class);
        var orderService2 = context.getBean(OrderService.class);
        var notificationManager = context.getBean(NotificationManager.class);
        var resource = context.getBean(HeavyResource.class);

        orderService.placeOrder();
        notificationManager.sendNotification("Your order has been placed! 😁");
    }

}

// DEMO CODE
/*
 * PROBLEM: If we forget to set the payment service we will get an error when we call placeOrder
 * Setter Injection should be used when the dependency is optional
 * It is more common to use Constructor Injection
 * */

//        orderService.setPaymentService(new StripePaymentService());
//        var orderService = new OrderService(new PayPalPaymentService());
