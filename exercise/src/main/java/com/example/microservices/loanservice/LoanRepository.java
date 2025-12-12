package com.example.microservices.loanservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanRepository {

    private final Map<String, Loan> loans = new HashMap<>();

    public Loan save(Loan loan) {
        loans.put(loan.getId(), loan);
        return loan;
    }

    public List<Loan> findAll() {
        return new ArrayList<>(loans.values());
    }
}