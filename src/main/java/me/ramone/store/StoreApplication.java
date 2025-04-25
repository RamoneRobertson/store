package me.ramone.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {

        // ConfigurableApplicationContext implements ApplicationContext so we can use it to manually close the context
        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var userService = context.getBean(UserService.class);
        userService.register(new User(804578L, "Ramone", "ramone@gmail.com", "123Spring456"));
        userService.register(new User(804578L, "Ramone", "ramone@gmail.com", "123Spring456"));


//        var orderService = context.getBean(OrderService.class);
//        var resource = context.getBean(HeavyResource.class);
//
//        orderService.placeOrder();
        context.close(); // We can see our pre destroy method being called here.
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
