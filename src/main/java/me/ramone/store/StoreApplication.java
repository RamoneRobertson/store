package me.ramone.store;

import me.ramone.store.entities.User;
import me.ramone.store.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

        var repository = context.getBean(UserRepository.class);

        var user = User.builder()
                .name("Zani")
                .email("zani@aeverado.bank.co")
                .password("Overtime")
                .build();

        repository.save(user);
    }

}

