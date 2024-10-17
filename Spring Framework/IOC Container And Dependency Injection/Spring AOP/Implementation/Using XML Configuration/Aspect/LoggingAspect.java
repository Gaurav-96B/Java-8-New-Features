package com.example.aspect;

public class LoggingAspect {

    public void logBefore() {
        System.out.println("Logging BEFORE method execution");
    }

    public void logAfter() {
        System.out.println("Logging AFTER method execution");
    }
}
