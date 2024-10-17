package com.example;

import com.example.config.AppConfig;
import com.example.dao.UserDao;
import com.example.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserDao userDao = context.getBean(UserDao.class);

        // Create a new user
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");

        // Save the user to the database
        userDao.save(user);

        // Retrieve the user by ID
        User retrievedUser = userDao.findById(user.getId());
        System.out.println("Retrieved User: " + retrievedUser.getName());

        context.close();
    }
}
