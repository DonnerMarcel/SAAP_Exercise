package com.example.layered.repository;

import com.example.layered.model.Loan;
import java.util.*;

public class LoanRepository {
    private final Map<String, Loan> loans = new HashMap<>();

    public Loan save(Loan loan) {
        loans.put(loan.getId(), loan);
        return loan;
    }

    public List<Loan> findAll() {
        return new ArrayList<>(loans.values());
    }

    public Optional<Loan> findById(String id) {
        return Optional.ofNullable(loans.get(id));
    }
}
