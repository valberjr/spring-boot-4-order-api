package com.laboratory.order_service.application.usecase;

import com.laboratory.order_service.domain.entity.OrderEntity;
import com.laboratory.order_service.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateOrderUseCase {
    private final OrderRepository repository;

    public CreateOrderUseCase(OrderRepository repository) {
        this.repository = repository;
    }

    public OrderEntity save(OrderEntity order) {
        return repository.save(order);
    }
}
