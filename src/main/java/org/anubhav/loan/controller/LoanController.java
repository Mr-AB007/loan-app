package org.anubhav.loan.controller;

import org.anubhav.loan.dto.CustomerDto;
import org.anubhav.loan.dto.LoanDto;
import org.anubhav.loan.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loan/api")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("loans")
    public ResponseEntity<List<LoanDto>> findAllLoans() {
        List<LoanDto> loanDtoList = loanService.findAllLoans();
        return loanDtoList.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(loanDtoList);
    }
    @GetMapping("criteria")
    public ResponseEntity<List<LoanDto>> findLoansByCriteria() {
        List<LoanDto> loanDtoList = loanService.findLoansByCriteria();
        return loanDtoList.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(loanDtoList);
    }

    @PutMapping("/status-update")
    public ResponseEntity<String> updateLoanStatusBasedOnApplicationDate() {
        try {
            String message = loanService.updateLoanStatusBasedOnApplicationDate();
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error updating loan statuses.");
        }
    }

    @GetMapping("customers/more-than-one-loan")
    public ResponseEntity<List<CustomerDto>> getCustomersWithMoreThanOneLoan() {
        List<CustomerDto> customerDtoList = loanService.findCustomersWithMoreThanOneLoan();
        return customerDtoList.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(customerDtoList);
    }
    @GetMapping("loan/{customerId}")
    public ResponseEntity<List<LoanDto>> findLoanByCustomerId(@PathVariable Integer customerId){
        List<LoanDto> loanDtoList = loanService.findLoanByCustomerId(customerId);
        return loanDtoList.isEmpty()? ResponseEntity.noContent().build():
                ResponseEntity.ok(loanDtoList);
    }
}
