package com.example.assign.Assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LoanStoreTest {
    private LoanStore loanStore;

    @BeforeEach
    public void setUp() {
        loanStore = new LoanStore();
    }

    @Test
    public void testAddValidLoan() {
        Loan loan = new Loan("L1", "C1", "LEN1", 10000, 10000, new Date(123, 5, 6), 0.01, new Date(123, 5, 7), 0.01);
        loanStore.addLoan(loan);

        // Add assertions here to check if the loan was added correctly
    }

    @Test
    public void testAddInvalidLoan() {
        Loan loan = new Loan("L2", "C1", "LEN1", 20000, 5000, new Date(123, 5, 1), 0.01, new Date(123, 5, 8), 0.01);
        // Assert that adding an invalid loan throws an exception
        assertThrows(Exception.class, () -> loanStore.addLoan(loan));
    }

    @Test
    public void testLoanAggregation() {
        // Verify aggregation logic
    }

    @Test
    public void testAlertOnDueDateCrossed() {
        // Add test cases to verify alert logging when due date is crossed
    }
}

