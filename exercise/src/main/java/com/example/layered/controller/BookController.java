package com.example.layered.controller;

import com.example.layered.service.BookService;
import com.example.layered.service.LoanService;

public class BookController {

    private final BookService bookService;
    private final LoanService loanService;

    public BookController(BookService bookService, LoanService loanService) {
        this.bookService = bookService;
        this.loanService = loanService;
    }

    public void demo() {
        System.out.println("=== BOOK CRUD & LOAN DEMO ===");

        bookService.createBook("1", "Clean Code", "Robert C. Martin");
        bookService.createBook("2", "Effective Java", "Joshua Bloch");

        System.out.println("All books:");
        bookService.getAllBooks().forEach(b ->
            System.out.println(b.getId() + " | " + b.getTitle() + " | borrowed=" + b.isBorrowed())
        );

        System.out.println("\nBorrowing book with ID 1 by user u1...");
        loanService.borrowBook("u1", "1");

        System.out.println("\nBooks after loan:");
        bookService.getAllBooks().forEach(b ->
            System.out.println(b.getId() + " | " + b.getTitle() + " | borrowed=" + b.isBorrowed())
        );

        System.out.println("\nAll loans:");
        loanService.getAllLoans().forEach(l ->
            System.out.println(l.getId() + " | user=" + l.getUserId() + " | book=" + l.getBookId())
        );
    }
}
