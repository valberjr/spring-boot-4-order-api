package com.laboratory.order_service.domain.repository;

import com.laboratory.order_service.domain.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderRepository {

    OrderEntity save(OrderEntity order);

    Page<OrderEntity> findAll(Pageable pageable);
}
