package com.laboratory.order_service.infrastructure.config;

import com.laboratory.order_service.domain.entity.OrderEntity;
import com.laboratory.order_service.domain.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@ConditionalOnProperty(name = "app.runner.enabled", havingValue = "true", matchIfMissing = true)
public class DatabaseLoader implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseLoader.class);

    private final OrderRepository repository;

    public DatabaseLoader(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        var order = OrderEntity.create(new BigDecimal("10.00"));
        repository.save(order);
        LOGGER.info("Order saved with ID: {}", order.getId());
    }
}
