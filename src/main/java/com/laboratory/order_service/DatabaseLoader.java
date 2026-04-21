package com.laboratory.order_service;

import com.laboratory.order_service.entity.OrderEntity;
import com.laboratory.order_service.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseLoader.class);

    private final OrderRepository repository;

    public DatabaseLoader(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        var order = new OrderEntity(new BigDecimal("10.00"), OrderEntity.Status.PROCESSED);
        repository.save(order);
        LOGGER.info("Order saved with ID: {}", order.getId());
    }
}
