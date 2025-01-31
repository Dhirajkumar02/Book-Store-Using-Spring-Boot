package com.bookstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Ensure it's Long, int, or Integer

    private String title;
    private String author;
    private double price;

    // Default constructor
    public Book() {}

    // Getters and Setters
    public Long getId() {  // Ensure the getter method is present
        return id;
    }

    public void setId(Long id) {  // Ensure the setter method is present
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
