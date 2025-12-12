package com.example.microservices.api;

import com.example.microservices.bookservice.BookRepository;
import com.example.microservices.bookservice.BookService;
import com.example.microservices.loanservice.LoanRepository;
import com.example.microservices.loanservice.LoanService;
import com.example.microservices.userservice.UserRepository;
import com.example.microservices.userservice.UserService;

public class DemoApplication {

    public static void main(String[] args) {

        // "Microservices" – im Prototyp alles in einem Prozess
        BookService bookService = new BookService(new BookRepository());
        UserService userService = new UserService(new UserRepository());
        LoanService loanService = new LoanService(new LoanRepository(), bookService, userService);

        // Seed-Daten
        bookService.createBook("b1", "Clean Architecture", "Robert C. Martin");
        userService.createUser("u1", "Alice");

        System.out.println("Book available? " + bookService.isAvailable("b1"));

        System.out.println("Borrowing book...");
        loanService.borrowBook("u1", "b1");

        System.out.println("Book available after loan? " + bookService.isAvailable("b1"));

        System.out.println("All loans:");
        loanService.getAllLoans().forEach(l ->
            System.out.println(l.getId() + " | user=" + l.getUserId() + " | book=" + l.getBookId())
        );
    }
}
