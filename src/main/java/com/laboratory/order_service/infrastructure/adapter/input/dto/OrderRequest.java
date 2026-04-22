package com.laboratory.order_service.infrastructure.adapter.input.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record OrderRequest(
        @NotNull(message = "Amount cannot be null")
        BigDecimal amount) {
}
