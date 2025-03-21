package org.anubhav.loan.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "loan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer loanId;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    @JsonBackReference
    private Customer customer;

    @Column
    @NotNull
    private Double loanAmount;

    @Column
    @NotNull
    private Integer loanTerm;

    @Column
    @NotNull
    private Double interestRate;

    @Column
    @NotNull
    private LocalDateTime applicationDate;

    @Column
    @NotNull
    private String status;
}
