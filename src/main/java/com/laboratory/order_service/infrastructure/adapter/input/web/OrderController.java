package com.laboratory.order_service.infrastructure.adapter.input.web;

import com.laboratory.order_service.application.usecase.CreateOrderUseCase;
import com.laboratory.order_service.application.usecase.ListOrdersUseCase;
import com.laboratory.order_service.domain.entity.OrderEntity;
import com.laboratory.order_service.infrastructure.adapter.input.dto.OrderRequest;
import com.laboratory.order_service.infrastructure.adapter.input.dto.OrderResponse;
import com.laboratory.order_service.infrastructure.adapter.input.mapper.OrderMapper;
import jakarta.validation.Valid;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@NullMarked
@Valid
public class OrderController {
    private final ListOrdersUseCase listOrdersUseCase;
    private final CreateOrderUseCase createOrderUseCase;
    private final OrderMapper mapper;

    public OrderController(ListOrdersUseCase listOrdersUseCase, CreateOrderUseCase createOrderUseCase, OrderMapper mapper) {
        this.listOrdersUseCase = listOrdersUseCase;
        this.createOrderUseCase = createOrderUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        var createdOrder = createOrderUseCase.save(mapper.toEntity(request));
        return ResponseEntity.ok(mapper.toResponse(createdOrder));
    }

    @GetMapping
    public ResponseEntity<Page<OrderResponse>> listOrders(
            @PageableDefault(size = 10, sort = "createdAt") Pageable pageable) {
        Page<OrderEntity> orders = listOrdersUseCase.listAll(pageable);
        Page<OrderResponse> response = orders.map(mapper::toResponse);
        return ResponseEntity.ok(response);
    }
}
