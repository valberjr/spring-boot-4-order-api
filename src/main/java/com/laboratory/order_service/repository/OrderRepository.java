package com.laboratory.order_service.repository;

import com.laboratory.order_service.entity.OrderEntity;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@NullMarked
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
