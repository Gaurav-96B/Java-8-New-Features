package com.example;

import com.example.dao.UserDao;
import com.example.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = context.getBean(UserDao.class);

        // Create a new user and save
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        userDao.save(user);

        // Retrieve user by ID
        User retrievedUser = userDao.findById(user.getId());
        System.out.println("Retrieved User: " + retrievedUser.getName());
    }
}
