package com.example.microservices.bookservice;

import java.util.List;
import java.util.Optional;

public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public Book createBook(String id, String title, String author) {
        Book book = new Book(id, title, author);
        repo.save(book);
        return book;
    }

    public boolean isAvailable(String id) {
        Optional<Book> b = repo.findById(id);
        return b.isPresent() && !b.get().isBorrowed();
    }

    public void markBorrowed(String id) {
        repo.findById(id).ifPresent(b -> b.setBorrowed(true));
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }
}
