package com.example.layered;

import com.example.layered.controller.BookController;
import com.example.layered.repository.BookRepository;
import com.example.layered.repository.LoanRepository;
import com.example.layered.service.BookService;
import com.example.layered.service.LoanService;

public class LibraryApplication {

    public static void main(String[] args) {
        BookRepository bookRepo = new BookRepository();
        LoanRepository loanRepo = new LoanRepository();

        BookService bookService = new BookService(bookRepo);
        LoanService loanService = new LoanService(loanRepo, bookService);

        BookController controller = new BookController(bookService, loanService);
        controller.demo();
    }
}
