package com.example.layered.service;

import com.example.layered.model.Loan;
import com.example.layered.repository.LoanRepository;

import java.util.List;
import java.util.UUID;

public class LoanService {

    private final LoanRepository loanRepo;
    private final BookService bookService;

    public LoanService(LoanRepository loanRepo, BookService bookService) {
        this.loanRepo = loanRepo;
        this.bookService = bookService;
    }

    /**
     * Borrow a book: checks availability, marks the book as borrowed and records a loan.
     * Throws IllegalStateException if book not available.
     */
    public Loan borrowBook(String userId, String bookId) {
        if (!bookService.isAvailable(bookId)) {
            throw new IllegalStateException("Book is not available for loan");
        }

        // mark book borrowed (local transaction in layered design)
        bookService.markBorrowed(bookId);

        Loan loan = new Loan(UUID.randomUUID().toString(), bookId, userId);
        loanRepo.save(loan);
        return loan;
    }

    public List<Loan> getAllLoans() {
        return loanRepo.findAll();
    }
}
