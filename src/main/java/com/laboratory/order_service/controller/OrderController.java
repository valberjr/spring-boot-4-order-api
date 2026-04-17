package com.laboratory.order_service.controller;

import com.laboratory.order_service.model.OrderRequest;
import com.laboratory.order_service.model.OrderResponse;
import com.laboratory.order_service.service.OrderService;
import org.jspecify.annotations.NullMarked;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@NullMarked
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        OrderResponse response = orderService.processOrder(request.orderId(), request.amount());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/debug/thread")
    public String checkThread() {
        return "Current Thread: " + Thread.currentThread();
    }
}
