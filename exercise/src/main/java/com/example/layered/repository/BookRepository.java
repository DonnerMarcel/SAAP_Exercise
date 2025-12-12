package com.example.layered.repository;

import java.util.*;

import com.example.layered.model.Book;

public class BookRepository {

    private final Map<String, Book> books = new HashMap<>();

    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    public Optional<Book> findById(String id) {
        return Optional.ofNullable(books.get(id));
    }

    public Book save(Book book) {
        books.put(book.getId(), book);
        return book;
    }

    public boolean delete(String id) {
        return books.remove(id) != null;
    }
}
