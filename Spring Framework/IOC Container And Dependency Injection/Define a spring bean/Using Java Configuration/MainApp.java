package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load the Spring context using Java-based configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the Person bean from the Spring context
        Person person = context.getBean(Person.aclass);

        // Use the Person bean
        System.out.println(person);
    }
}
