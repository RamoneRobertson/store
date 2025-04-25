package me.ramone.store;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private NotificationService notificationService;

    public UserService(NotificationService notificationService, UserRepository userRepository) {
        this.notificationService = notificationService;
        this.userRepository = userRepository;
    }

    public void register(User user){
        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new IllegalArgumentException("a user with the email " + user.getEmail() + " already exists");
        }

        userRepository.save(user);
        notificationService.send("You registered successfully!", user.getEmail());
    }
}
