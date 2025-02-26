package com.example.mocking.models;

public class User {
    private int id;
    private String name;
    private String email;

    // Constructor vacío
    public User() {}

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
