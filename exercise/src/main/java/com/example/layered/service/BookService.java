package com.example.layered.service;

import com.example.layered.model.Book;
import com.example.layered.repository.BookRepository;

import java.util.List;
import java.util.Optional;

public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public Book createBook(String id, String title, String author) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        Book book = new Book(id, title, author);
        return repo.save(book);
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Optional<Book> getBookById(String id) {
        return repo.findById(id);
    }

    public boolean deleteBook(String id) {
        return repo.delete(id);
    }

    // new helpers for loan handling
    public boolean isAvailable(String id) {
        return repo.findById(id).map(b -> !b.isBorrowed()).orElse(false);
    }

    public void markBorrowed(String id) {
        repo.findById(id).ifPresent(b -> b.setBorrowed(true));
    }

    public void markReturned(String id) {
        repo.findById(id).ifPresent(b -> b.setBorrowed(false));
    }
}
