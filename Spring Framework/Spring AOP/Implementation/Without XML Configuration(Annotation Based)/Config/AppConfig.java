package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.example")  // Scan components in the package
@EnableAspectJAutoProxy  // Enable AOP proxying
public class AppConfig {

    // You don't need explicit bean declarations here unless you want to manually define beans
}
