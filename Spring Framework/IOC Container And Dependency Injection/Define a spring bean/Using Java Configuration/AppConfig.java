package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Define the Address bean
    @Bean
    public Address address() {
        return new Address("456 Oak St", "Los Angeles", "USA");
    }

    // Define the Person bean and inject the Address bean
    @Bean
    public Person person() {
        return new Person("Jane Doe", 28, address());
    }
}
