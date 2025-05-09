package me.ramone.store.services;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import me.ramone.store.entities.Address;
import me.ramone.store.entities.Category;
import me.ramone.store.entities.Product;
import me.ramone.store.entities.User;
import me.ramone.store.repositories.AddressRepository;
import me.ramone.store.repositories.ProductRepository;
import me.ramone.store.repositories.ProfileRepository;
import me.ramone.store.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final EntityManager entityManager;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void showRelatedEntities(){
       var profile = profileRepository.findById(5L).orElseThrow();
        System.out.println(profile.getUser().getEmail());

    }

    @Transactional
    public void showEntityStates (){
        var user = User.builder()
                .name("Uncle Drew")
                .email("drewschcooledyou@mail.com")
                .password("password")
                .build();

        if(entityManager.contains(user)){
            System.out.println(user.getName() + " is persistent");
        } else {
            System.out.println(user.getName() + " is transient / detached");
        }

        userRepository.save(user);

        if(entityManager.contains(user)){
            System.out.println(user.getName() + " is persistent");
        } else {
            System.out.println(user.getName() + " is not transient / detached");
        }
    }

    public void fetchAddress(){
       var address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getState());
    }

    public void persistRelated(){
        var user = User.builder()
                .name("Uncle Drew")
                .email("drew@nba.com")
                .password("password")
                .build();

        var address = Address.builder()
                .city("Chicago")
                .state("Illinois")
                .zip("1234567")
                .street("St Madison Avenue")
                .build();

        user.addAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated(){
        var user = userRepository.findById(3L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
    }

    @Transactional
    public void manageProducts(){
        var category = categoryRepository.findById((byte) 1).orElseThrow();

        var product = Product.builder()
                .name("PS5 Controller")
                .price(BigDecimal.valueOf(1750))
                .description("Description of product ps5 controller")
                .category(category)
                .build();

        productRepository.save(product);
    }

    public void addToWishList(){
       productRepository.f
    }
}
