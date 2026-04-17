package com.laboratory.order_service.model;

import org.jspecify.annotations.NullMarked;

@NullMarked
public record OrderResponse(String id, String status, String txId) {
}
