package com.laboratory.order_service.infrastructure.adapter.output.persistence;


import com.laboratory.order_service.domain.entity.OrderEntity;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@NullMarked
@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
}
