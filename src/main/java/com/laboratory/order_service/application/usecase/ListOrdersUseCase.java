package com.laboratory.order_service.application.usecase;

import com.laboratory.order_service.domain.entity.OrderEntity;
import com.laboratory.order_service.domain.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ListOrdersUseCase {

    private final OrderRepository repository;

    public ListOrdersUseCase(OrderRepository repository) {
        this.repository = repository;
    }

    public Page<OrderEntity> listAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
