package com.laboratory.order_service.infrastructure.adapter.input.web;

import com.laboratory.order_service.application.usecase.CreateOrderUseCase;
import com.laboratory.order_service.infrastructure.adapter.input.dto.OrderRequest;
import com.laboratory.order_service.infrastructure.adapter.input.dto.OrderResponse;
import com.laboratory.order_service.infrastructure.adapter.input.mapper.OrderMapper;
import jakarta.validation.Valid;
import org.jspecify.annotations.NullMarked;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@NullMarked
@Valid
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;
    private final OrderMapper mapper;

    public OrderController(CreateOrderUseCase createOrderUseCase, OrderMapper mapper) {
        this.createOrderUseCase = createOrderUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        var createdOrder = createOrderUseCase.save(mapper.toEntity(request));
        return ResponseEntity.ok(mapper.toResponse(createdOrder));
    }
}
