package com.laboratory.order_service.infrastructure.context;

public final class RequestContext {

    private RequestContext() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    public static final ScopedValue<String> TRANSACTION_ID = ScopedValue.newInstance();
}
