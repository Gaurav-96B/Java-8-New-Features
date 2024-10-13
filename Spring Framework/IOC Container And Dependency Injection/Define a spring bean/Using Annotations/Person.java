package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Value("Alice")
    private String name;
    @Value("25")
    private int age;

    @Autowired
    private Address address;  // Automatically inject the Address bean

    public Person() {}

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", address=" + address + "}";
    }
}
