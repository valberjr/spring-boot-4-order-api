package com.laboratory.order_service.config;

import com.laboratory.order_service.AppConstants;
import com.laboratory.order_service.context.RequestContext;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class RequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String txId = ((HttpServletRequest) request).getHeader(AppConstants.X_TRANSACTION_ID);
        if (txId == null) {
            txId = UUID.randomUUID().toString();
        }

        try {
            ScopedValue.where(RequestContext.TRANSACTION_ID, txId).run(() -> {
                try {
                    chain.doFilter(request, response);
                } catch (IOException | ServletException e) {
                    throw new FilterExceptionWrapper(e);
                }
            });
        } catch (FilterExceptionWrapper e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException c) throw c;
            if (cause instanceof ServletException c) throw c;
            throw new ServletException(cause);
        }
    }

    private static class FilterExceptionWrapper extends RuntimeException {
        public FilterExceptionWrapper(Exception cause) {
            super(cause);
        }
    }
}
