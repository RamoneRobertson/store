package me.ramone.store;

import org.springframework.stereotype.Service;

@Service
public interface UserRepository {
    void save(User user);
    User findByEmail(String email);
}
