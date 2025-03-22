-- Insert more customers
INSERT INTO customer (customer_id, name, email, credit_score) VALUES (1, 'John Doe', 'john.doe@example.com', 750);
INSERT INTO customer (customer_id, name, email, credit_score) VALUES (2, 'Alice Smith', 'alice.smith@example.com', 800);
INSERT INTO customer (customer_id, name, email, credit_score) VALUES (3, 'Michael Brown', 'michael.brown@example.com', 720);
INSERT INTO customer (customer_id, name, email, credit_score) VALUES (4, 'Sarah Wilson', 'sarah.wilson@example.com', 680);
INSERT INTO customer (customer_id, name, email, credit_score) VALUES (5, 'David Johnson', 'david.johnson@example.com', 790);

-- Insert more loans (Some with latest dates to prevent rejection)
INSERT INTO loan (loan_id, customer_id, loan_amount, loan_term, interest_rate, application_date, status)
VALUES (1, 1, 1500000, 96, 5.5, '2025-03-15T10:30:00', 'approved');

INSERT INTO loan (loan_id, customer_id, loan_amount, loan_term, interest_rate, application_date, status)
VALUES (2, 1, 500000, 60, 4.5, '2024-01-10T09:15:00', 'approved');

INSERT INTO loan (loan_id, customer_id, loan_amount, loan_term, interest_rate, application_date, status)
VALUES (3, 2, 2000000, 120, 6.0, '2023-12-01T14:45:00', 'approved');

INSERT INTO loan (loan_id, customer_id, loan_amount, loan_term, interest_rate, application_date, status)
VALUES (4, 3, 1000000, 84, 5.0, '2023-11-20T12:00:00', 'approved');

INSERT INTO loan (loan_id, customer_id, loan_amount, loan_term, interest_rate, application_date, status)
VALUES (5, 3, 750000, 72, 4.8, '2024-03-15T08:45:00', 'approved'); -- Latest date (Safe from rejection)

INSERT INTO loan (loan_id, customer_id, loan_amount, loan_term, interest_rate, application_date, status)
VALUES (6, 4, 300000, 48, 4.2, '2024-02-28T11:30:00', 'approved'); -- Latest date (Safe from rejection)

INSERT INTO loan (loan_id, customer_id, loan_amount, loan_term, interest_rate, application_date, status)
VALUES (7, 5, 1800000, 96, 5.7, '2025-10-05T14:00:00', 'approved');

INSERT INTO loan (loan_id, customer_id, loan_amount, loan_term, interest_rate, application_date, status)
VALUES (8, 5, 250000, 36, 3.9, '2025-03-10T10:15:00', 'approved'); -- Latest date (Safe from rejection)
