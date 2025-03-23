package org.anubhav.loan.service;

import org.anubhav.loan.dto.CustomerDto;
import org.anubhav.loan.dto.LoanDto;
import org.anubhav.loan.entity.Loan;
import org.anubhav.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LoanService {
    @Autowired
    LoanRepository loanRepository;

    public List<LoanDto> findAllLoans(){
        return loanRepository.findAll().stream()
                .map(loan -> new LoanDto(
                        loan.getLoanId(),
                        loan.getLoanAmount(),
                        loan.getLoanTerm(),
                        loan.getInterestRate(),
                        loan.getApplicationDate(),
                        loan.getStatus()
                )).collect(Collectors.toList());
    }
    public List<LoanDto> findLoansByCriteria(){
        return loanRepository.findAll().stream()
                .filter(loan -> loan.getLoanAmount() > 1_000_000 && loan.getStatus().equalsIgnoreCase("approved") && loan.getLoanTerm() > 7 * 12)
                .map(loan -> new LoanDto(
                        loan.getLoanId(),
                        loan.getLoanAmount(),
                        loan.getLoanTerm(),
                        loan.getInterestRate(),
                        loan.getApplicationDate(),
                        loan.getStatus()
        )).collect(Collectors.toList());
    }

    public String updateLoanStatusBasedOnApplicationDate() {
        List<Loan> loansToUpdate = loanRepository.findAll().stream()
                .filter(loan -> {
                    LocalDate applicationDate = LocalDate.from(loan.getApplicationDate()); // Ensure this is LocalDate
                    // Calculate days between loan applicationDate and today
                    return ChronoUnit.DAYS.between(applicationDate, LocalDate.now()) > 30; // Only update loans older than 30 days
                })
                .collect(Collectors.toList());

        if (loansToUpdate.isEmpty()) {
            return "No loans found that need status updates.";
        }

        loansToUpdate.forEach(loan -> loan.setStatus("Rejected"));
        loanRepository.saveAll(loansToUpdate);

        return "Loan statuses updated successfully. Total loans updated: " + loansToUpdate.size();
    }



    public List<CustomerDto> findCustomersWithMoreThanOneLoan(){
        return loanRepository.findAll()
                .stream().collect(Collectors.groupingBy(Loan::getCustomer))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size()>1)
                .map(Map.Entry::getKey).map(customer -> new CustomerDto(
                        customer.getCustomerId(),
                        customer.getName(),
                        customer.getEmail()
                )).collect(Collectors.toList());

    }
    public List<LoanDto> findLoanByCustomerId(Integer customerId){
        return loanRepository.findAll().stream().filter(loan -> loan.getCustomer().getCustomerId() == customerId)
                .map(loan -> new LoanDto(
                        loan.getLoanId(),
                        loan.getLoanAmount(),
                        loan.getLoanTerm(),
                        loan.getInterestRate(),
                        loan.getApplicationDate(),
                        loan.getStatus()
                )).collect(Collectors.toList());
    }
}
