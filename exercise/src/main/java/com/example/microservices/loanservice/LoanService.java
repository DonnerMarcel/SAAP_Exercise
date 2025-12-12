package com.example.microservices.loanservice;

import java.util.List;
import java.util.UUID;

import com.example.microservices.bookservice.BookService;
import com.example.microservices.userservice.UserService;

public class LoanService {

    private final LoanRepository loanRepo;
    private final BookService bookService;   // würde in echt per REST aufgerufen
    private final UserService userService;   // dito

    public LoanService(LoanRepository loanRepo,
                       BookService bookService,
                       UserService userService) {
        this.loanRepo = loanRepo;
        this.bookService = bookService;
        this.userService = userService;
    }

    public Loan borrowBook(String userId, String bookId) {
        if (!userService.isActive(userId)) {
            throw new IllegalStateException("User is not active");
        }
        if (!bookService.isAvailable(bookId)) {
            throw new IllegalStateException("Book not available");
        }

        // In echt wäre das alles über das Netzwerk verteilt → härteres Konsistenzproblem
        bookService.markBorrowed(bookId);

        Loan loan = new Loan(UUID.randomUUID().toString(), userId, bookId);
        loanRepo.save(loan);
        return loan;
    }

    public List<Loan> getAllLoans() {
        return loanRepo.findAll();
    }
}
