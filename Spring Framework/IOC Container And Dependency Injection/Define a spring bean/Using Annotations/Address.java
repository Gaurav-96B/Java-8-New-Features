package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Address {
    @Value("789 Pine St")
    private String street;
    @Value("Chicago")
    private String city;
    @Value("USA")
    private String country;

    public Address() {}

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    // Getters and Setters
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    @Override
    public String toString() {
        return "Address{street='" + street + "', city='" + city + "', country='" + country + "'}";
    }
}
