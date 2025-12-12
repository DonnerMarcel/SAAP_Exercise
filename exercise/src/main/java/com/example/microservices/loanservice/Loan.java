package com.example.microservices.loanservice;

import java.time.LocalDate;

public class Loan {
    private final String id;
    private final String userId;
    private final String bookId;
    private final LocalDate loanDate;

    public Loan(String id, String userId, String bookId) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.loanDate = LocalDate.now();
    }

    public String getId() { return id; }

    public String getUserId() { return userId; }

    public String getBookId() { return bookId; }

    public LocalDate getLoanDate() { return loanDate; }
}
