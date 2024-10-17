package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.model.User;
import com.example.dao.UserDao;
import com.example.config.AppConfig;

public class MainApp {
    public static void main(String[] args) {
        // Load the Spring context using Java configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the UserDao bean
        UserDao userDao = context.getBean(UserDao.class);

        // Create a new user
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");

        // Save the user to the database
        userDao.save(user);
        System.out.println("User saved successfully.");

        // Find user by ID
        User retrievedUser = userDao.findById(1);
        System.out.println("Retrieved User: " + retrievedUser);

        // Update user
        retrievedUser.setEmail("john.doe@example.com");
        userDao.update(retrievedUser);
        System.out.println("User updated successfully.");

        // Delete user by ID
        userDao.deleteById(1);
        System.out.println("User deleted successfully.");
    }
}
