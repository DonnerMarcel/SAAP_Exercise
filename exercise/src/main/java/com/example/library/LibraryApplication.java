package com.example.library;

import com.example.library.controller.BookController;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;

public class LibraryApplication {

    public static void main(String[] args) {

        BookRepository repo = new BookRepository();
        BookService service = new BookService(repo);
        BookController controller = new BookController(service);

        controller.demo();  // Prototype Test
    }
}
