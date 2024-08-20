package com.example.jpademo3.service;

public interface PaymentService {
    void processPayment(Long orderId, Double amount);
}
