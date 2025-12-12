package com.example.layered;

import com.example.layered.controller.BookController;
import com.example.layered.repository.BookRepository;
import com.example.layered.service.BookService;

public class LibraryApplication {

    public static void main(String[] args) {

        BookRepository repo = new BookRepository();
        BookService service = new BookService(repo);
        BookController controller = new BookController(service);

        controller.demo();  // Prototype Test
    }
}
