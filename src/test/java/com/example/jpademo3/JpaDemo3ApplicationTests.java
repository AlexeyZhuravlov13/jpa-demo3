package com.example.jpademo3;

import com.example.jpademo3.entity.Order;
import com.example.jpademo3.entity.Payment;
import com.example.jpademo3.exception.AmountExceedException;
import com.example.jpademo3.repository.OrderRepository;
import com.example.jpademo3.repository.PaymentRepository;
import com.example.jpademo3.service.OrderServiceImpl;
import com.example.jpademo3.service.PaymentServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JpaDemo3ApplicationTests {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @BeforeEach
    void setUp() {
        paymentRepository.deleteAll();
        orderRepository.deleteAll();
    }

    @Test
    void shouldSaveBothWhenAmountLessThen1000() {
        orderService.createOrder(1L, 999.0);
        Optional<Order> orderOptional = orderRepository.findById(1L);
        assertTrue(orderOptional.isPresent());
        Optional<Payment> paymentOptional = paymentRepository.findById(1L);
        assertTrue(paymentOptional.isPresent());
    }

    @Test
    void shouldNotSaveBothWhenAmountBiggerThen1000() {
        assertThrows(Exception.class, () -> orderService.createOrder(1L, 2000.0));
        Optional<Order> orderOptional = orderRepository.findById(1L);
        assertFalse(orderOptional.isPresent());
        Optional<Payment> paymentOptional = paymentRepository.findById(1L);
        assertFalse(paymentOptional.isPresent());
    }
}
