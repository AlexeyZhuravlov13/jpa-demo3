package com.example.jpademo3.service;

import com.example.jpademo3.entity.Payment;
import com.example.jpademo3.exception.AmountExceedException;
import com.example.jpademo3.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    /* in this case order will not be saved as the same transaction work
    if we changed it to REQUIRES_NEW order will be saved
    */
    public void processPayment(Long orderId, Double amount) {
        if (amount > 1000.0) {
            throw new AmountExceedException("Payment amount should be less or equal 1000");
        }
        Payment payment = Payment.builder().orderId(orderId).amount(amount).build();
        paymentRepository.save(payment);
    }
}
