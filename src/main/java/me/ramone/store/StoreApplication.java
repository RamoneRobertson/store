package me.ramone.store;

import me.ramone.store.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var user = User.builder()
                .id(1L)
                .name("Joe")
                .email("email")
                .password("password")
                .build();

        var category = new Category((byte)1, "Electronics");
        var product = new Product(1L, "Samsung TV", new java.math.BigDecimal("1000.00"));

        category.addProduct(product);
        System.out.println(category);
    }

}

