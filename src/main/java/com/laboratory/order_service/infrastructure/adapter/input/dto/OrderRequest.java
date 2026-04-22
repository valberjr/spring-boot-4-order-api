package com.laboratory.order_service.infrastructure.adapter.input.dto;

import jakarta.validation.constraints.NotNull;
import org.jspecify.annotations.NullMarked;

import java.math.BigDecimal;

@NullMarked
public record OrderRequest(
        @NotNull(message = "Amount cannot be null")
        BigDecimal amount) {
}
