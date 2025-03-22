INSERT INTO customer (customer_id, name, email, credit_score) VALUES (1, 'John Doe', 'john.doe@example.com', 750);
INSERT INTO customer (customer_id, name, email, credit_score) VALUES (2, 'Alice Smith', 'alice.smith@example.com', 800);

INSERT INTO loan (loan_id, customer_id, loan_amount, loan_term, interest_rate, application_date, status)
VALUES (1, 1, 1500000, 96, 5.5, '2024-02-15T10:30:00', 'approved');

INSERT INTO loan (loan_id, customer_id, loan_amount, loan_term, interest_rate, application_date, status)
VALUES (2, 1, 500000, 60, 4.5, '2024-01-10T09:15:00', 'approved');

INSERT INTO loan (loan_id, customer_id, loan_amount, loan_term, interest_rate, application_date, status)
VALUES (3, 2, 2000000, 120, 6.0, '2023-12-01T14:45:00', 'approved');
