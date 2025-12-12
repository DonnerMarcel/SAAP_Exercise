package com.example.layered.model;

import java.time.LocalDate;

public class Loan {
    private final String id;
    private final String bookId;
    private final String userId;
    private final LocalDate loanDate;

    public Loan(String id, String bookId, String userId) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.loanDate = LocalDate.now();
    }

    public String getId() { return id; }
    public String getBookId() { return bookId; }
    public String getUserId() { return userId; }
    public LocalDate getLoanDate() { return loanDate; }
}
