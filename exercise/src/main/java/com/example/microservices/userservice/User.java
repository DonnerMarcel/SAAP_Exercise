package com.example.microservices.userservice;

public class User {
    private final String id;
    private final String name;
    private boolean active;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.active = true;
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public boolean isActive() { return active; }

    public void deactivate() { this.active = false; }
}
