package org.anubhav.loan.dto;

public record CustomerDto(
        Integer customerId,
        String name,
        String email
) { }
