package com.laboratory.order_service.domain.repository;

import com.laboratory.order_service.domain.entity.OrderEntity;

public interface OrderRepository {

    OrderEntity save(OrderEntity order);
}
