package me.ramone.store;

import java.util.HashMap;

public class InMemoryUserRepository implements  UserRepository {
    private HashMap<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getEmail(), user);
    }
}
