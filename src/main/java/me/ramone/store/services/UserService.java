package me.ramone.store.services;


import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import me.ramone.store.entities.User;
import me.ramone.store.repositories.UserRepository;

@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    public void showEntitytate(){
        var user = User.builder()
                .name("Zani")
                .email("zani@aeverado.bank.co")
                .password("password")
                .build();

        if(entityManager.contains(user)){
            System.out.println("Entity is persistent");
        } else{
            System.out.println("Entity is transient/detached");
        }

        userRepository.save(user);
    }
}
