package com.example.layered.controller;

import com.example.layered.service.BookService;

public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    public void demo() {
        System.out.println("=== BOOK CRUD DEMO ===");

        service.createBook("1", "Clean Code", "Robert C. Martin");
        service.createBook("2", "Effective Java", "Joshua Bloch");

        System.out.println("All books:");
        service.getAllBooks().forEach(b ->
            System.out.println(b.getId() + " | " + b.getTitle())
        );

        System.out.println("Deleting book with ID 1...");
        service.deleteBook("1");

        System.out.println("Remaining:");
        service.getAllBooks().forEach(b ->
            System.out.println(b.getId() + " | " + b.getTitle())
        );
    }
}
