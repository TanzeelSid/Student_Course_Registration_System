package com.registration.model;

import java.util.regex.Pattern;

/**
 * Abstract base class representing a Person in the registration system.
 * Demonstrates encapsulation through private fields and validation.
 */
public abstract class Person {
    private String name;
    private String email;
    private String id;
    
    // Email validation pattern
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    
    /**
     * Constructor for Person
     * @param name The person's name
     * @param email The person's email
     * @param id The person's ID
     */
    public Person(String name, String email, String id) {
        setName(name);
        setEmail(email);
        setId(id);
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getId() {
        return id;
    }
    
    // Setters with validation (Encapsulation)
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name.trim();
    }
    
    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (!EMAIL_PATTERN.matcher(email.trim()).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email.trim();
    }
    
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        this.id = id.trim();
    }
    
    /**
     * Abstract method to display details - demonstrates abstraction
     * Subclasses must implement this method (Polymorphism)
     */
    public abstract void displayDetails();
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return id.equals(person.id);
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}