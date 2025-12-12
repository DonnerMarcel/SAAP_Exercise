package com.example.microservices.userservice;

import java.util.Optional;

public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User createUser(String id, String name) {
        User user = new User(id, name);
        repo.save(user);
        return user;
    }

    public boolean isActive(String id) {
        Optional<User> u = repo.findById(id);
        return u.isPresent() && u.get().isActive();
    }
}