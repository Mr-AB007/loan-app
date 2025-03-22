package org.anubhav.loan.dto;
import java.time.LocalDateTime;

public record LoanDto(
        Integer loanId,
        Double loanAmount,
        Integer loanTerm,
        Double interestRate,
        LocalDateTime applicationDate,
        String status
) { }
