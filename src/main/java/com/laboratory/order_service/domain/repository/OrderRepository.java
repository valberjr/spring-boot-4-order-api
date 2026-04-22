package com.laboratory.order_service.domain.repository;

import com.laboratory.order_service.domain.entity.OrderEntity;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@NullMarked
public interface OrderRepository {

    OrderEntity save(OrderEntity order);

    Page<OrderEntity> findAll(Pageable pageable);
}
