package com.example.service;

public class UserService {

    public String getUserById(int id) {
        System.out.println("Executing method getUserById with ID: " + id);
        return "User" + id;
    }

    public void updateUser(int id, String name) {
        System.out.println("Updating User: " + id + " to name: " + name);
    }
}
