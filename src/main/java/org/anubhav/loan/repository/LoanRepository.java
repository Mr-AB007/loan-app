package org.anubhav.loan.repository;

import org.anubhav.loan.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {
    List<Loan> findByCustomer_CustomerId(Integer customerId); // Find all loans by customer ID
}
