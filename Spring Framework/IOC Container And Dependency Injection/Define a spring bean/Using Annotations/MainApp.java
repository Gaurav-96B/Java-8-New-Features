package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.demo")  // Enable component scanning
public class MainApp {
    public static void main(String[] args) {
        // Load the Spring context using annotation-based configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);

        // Retrieve the Person bean from the Spring context
        Person person = context.getBean(Person.class);

        // Use the Person bean
        System.out.println(person);
    }
}
