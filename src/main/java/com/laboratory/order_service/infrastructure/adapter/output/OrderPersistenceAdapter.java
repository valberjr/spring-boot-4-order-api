package com.laboratory.order_service.infrastructure.adapter.output;

import com.laboratory.order_service.domain.entity.OrderEntity;
import com.laboratory.order_service.domain.repository.OrderRepository;
import com.laboratory.order_service.infrastructure.adapter.output.persistence.OrderJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderPersistenceAdapter implements OrderRepository {

    private final OrderJpaRepository repository;

    public OrderPersistenceAdapter(OrderJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderEntity save(OrderEntity order) {
        return repository.save(order);
    }
}
