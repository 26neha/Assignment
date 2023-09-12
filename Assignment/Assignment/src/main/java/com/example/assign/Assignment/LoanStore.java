package com.example.assign.Assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanStore {
    private List<Loan> loans = new ArrayList<>();
    private Map<String, Double> lenderAggregation = new HashMap<>();
    private Map<Double, Double> interestAggregation = new HashMap<>();
    private Map<String, Double> customerAggregation = new HashMap<>();

    public void addLoan(Loan loan) {
        try {
            if (loan.getPaymentDate().after(loan.getDueDate())) {
                throw new Exception("Payment date cannot be greater than the due date for loan ID: " + loan.getLoanId());
            }
            loans.add(loan);
            updateAggregations(loan);
            checkDueDate(loan);
        } catch (Exception e) {
            // Handle the exception as needed, e.g., log the error.
            System.err.println(e.getMessage());
        }
    }

    private void updateAggregations(Loan loan) {
        lenderAggregation.put(loan.getLenderId(), lenderAggregation.getOrDefault(loan.getLenderId(), 0.0) + loan.getRemainingAmount());
        interestAggregation.put(loan.getInterestPerDay(), interestAggregation.getOrDefault(loan.getInterestPerDay(), 0.0) + loan.getInterestPerDay());
        customerAggregation.put(loan.getCustomerId(), customerAggregation.getOrDefault(loan.getCustomerId(), 0.0) + loan.getRemainingAmount());
    }

    private void checkDueDate(Loan loan) {
        if (loan.getPaymentDate().after(loan.getDueDate())) {
            System.out.println("ALERT: Loan ID " + loan.getLoanId() + " has crossed the due date.");
        }
    }

}
