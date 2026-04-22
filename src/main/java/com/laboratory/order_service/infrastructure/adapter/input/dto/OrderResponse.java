package com.laboratory.order_service.infrastructure.adapter.input.dto;

import org.jspecify.annotations.NullMarked;

@NullMarked
public record OrderResponse(String status, String txId) {
}
