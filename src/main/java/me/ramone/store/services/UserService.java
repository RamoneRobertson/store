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
        var category = new Category("Grocery");;

        var product1 = Product.builder()
                .name("J Taste High Grade Green Tea")
                .price(BigDecimal.valueOf(1975))
                .description("J Taste’s High Grade Green Tea With Matcha teabags use only high grade green tea leaves from Kagoshima and pure Kyoto matcha powder from Uji, housed in eco-friendly, plastic-free teabags, to ensure you’re getting the most natural flavors with every sip.")
                .category(category)
                .build();
        var product2 = Product.builder()
                .name("Chayudo Uji Matcha Sablé Cookies")
                .price(BigDecimal.valueOf(1429))
                .description("These matcha sablé cookies are made with real high-grade matcha powder sourced from Uji, Kyoto, the home of matcha green tea. They also contain high quality eggs, and butter, which give the cookies a rich and unique flavor.")
                .category(category)
                .build();
        var product3 = Product.builder()
                .name("Morinaga Hi-Chew Soft Candy Strawberry Flavor 12 Pieces")
                .price(BigDecimal.valueOf(990))
                .description("Would you like to experience the taste and texture of juicy Japanese strawberries while eating a soft candy? Enjoy the great flavor and unique chewiness of this special strawberry Hi-Chew from Morinaga.")
                .category(category)
                .build();

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
    }

    public void addToWishList(){
        var products = productRepository.findAll();
    }
}
