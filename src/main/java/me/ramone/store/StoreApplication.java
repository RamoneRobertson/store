package me.ramone.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);

        // DEMO CODE
//        var orderService = new OrderService(new PayPalPaymentService());
        /*
        * PROBLLEM: If we forget to set the payment service we will get an error when we call placeOrder
        * Setter Injection should be used when the dependency is optional
        * It is more common to use Constructor Injection
        * */

//        orderService.setPaymentService(new StripePaymentService());
//        orderService.placeOrder();
    }

}
