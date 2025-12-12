package com.example.microservices.bookservice;

public class Book {
    private final String id;
    private final String title;
    private final String author;
    private boolean borrowed;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }

    public String getId() { return id; }

    public String getTitle() { return title; }

    public String getAuthor() { return author; }

    public boolean isBorrowed() { return borrowed; }

    public void setBorrowed(boolean borrowed) { this.borrowed = borrowed; }
}

