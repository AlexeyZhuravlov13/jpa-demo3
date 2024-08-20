package com.example.jpademo3.service;


import com.example.jpademo3.entity.Order;
import com.example.jpademo3.exception.AmountExceedException;
import com.example.jpademo3.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final PaymentService paymentService;

    @Override
    @Transactional
    public void createOrder(Long id, Double amount) {
        Order order = Order.builder().id(id).amount(amount).build();
        orderRepository.save(order);
        try {
            paymentService.processPayment(id, amount);
        } catch (AmountExceedException e) {
            log.error("Payment service throw error", e);
        }
    }
}
