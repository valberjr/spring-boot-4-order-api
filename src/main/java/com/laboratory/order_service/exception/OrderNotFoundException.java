package com.laboratory.order_service.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String id) {
        super("Order " + id + " not found");
    }
}
