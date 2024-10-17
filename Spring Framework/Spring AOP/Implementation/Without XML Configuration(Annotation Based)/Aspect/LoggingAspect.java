package com.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Aspect
@Component  // Automatically detected as a Spring bean
public class LoggingAspect {

    @Before("execution(* com.example.service.UserService.*(..))")
    public void logBefore() {
        System.out.println("Logging BEFORE method execution");
    }

    @After("execution(* com.example.service.UserService.*(..))")
    public void logAfter() {
        System.out.println("Logging AFTER method execution");
    }
}
