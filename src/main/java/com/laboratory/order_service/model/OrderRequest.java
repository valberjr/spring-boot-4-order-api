package com.laboratory.order_service.model;

import org.jspecify.annotations.NullMarked;

@NullMarked
public record OrderRequest(String orderId, Double amount) {
}
