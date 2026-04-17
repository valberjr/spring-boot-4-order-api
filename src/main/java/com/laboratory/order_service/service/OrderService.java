package com.laboratory.order_service.service;

import com.laboratory.order_service.context.RequestContext;
import com.laboratory.order_service.model.OrderResponse;
import org.jspecify.annotations.NullMarked;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@NullMarked
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    public OrderResponse processOrder(String orderId, Double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("The order amount must be positive.");
        }

        String txId = RequestContext.TRANSACTION_ID.orElse("NO-TX-ID");

        LOGGER.info("Processing order [{}] with TX: [{}]", orderId, txId);

        return new OrderResponse(orderId, "PROCESSED", txId);
    }
}
