package com.laboratory.order_service.infrastructure.config;

public final class AppConstants {
    private AppConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // Headers
    public static final String X_TRANSACTION_ID = "X-Transaction-ID";

    // Local Api
    public static final String LOCAL_API_URL = "http://localhost:8080";
}
