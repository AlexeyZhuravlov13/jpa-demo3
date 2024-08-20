package com.example.jpademo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemo3Application {

    public static void main(String[] args) {
        SpringApplication.run(JpaDemo3Application.class, args);
    }

	/*

✅ Сделай задачку


Проверь поведение транзакций:
- Напиши тест, который вызывает createOrder с суммой меньше 1000 и проверяет, что заказ и платеж сохраняются.
- Напиши другой тест, который вызывает createOrder с суммой больше 1000 и проверяет, что заказ не сохраняется при ошибке в платеже.

Вопросы:
Какой будет результат, если метод processPayment выбрасывает исключение?
Что произойдет с транзакцией, если исключение произойдет при вызове processPayment в методе createOrder?
Примени пропагации транзакций на свою усмотрение для тестирования и практики
	 */
}
