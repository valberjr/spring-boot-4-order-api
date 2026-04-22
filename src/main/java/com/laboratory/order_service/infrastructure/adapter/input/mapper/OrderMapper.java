package com.laboratory.order_service.infrastructure.adapter.input.mapper;

import com.laboratory.order_service.domain.entity.OrderEntity;
import com.laboratory.order_service.infrastructure.adapter.input.dto.OrderRequest;
import com.laboratory.order_service.infrastructure.adapter.input.dto.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ObjectFactory;

@Mapper
public interface OrderMapper {
    @ObjectFactory
    default OrderEntity create(OrderRequest request) {
        return OrderEntity.create(request.amount());
    }

    OrderEntity toEntity(OrderRequest orderRequest);

    @Mapping(target = "txId", expression = "java(com.laboratory.order_service.infrastructure.context.RequestContext.TRANSACTION_ID.get())")
    OrderResponse toResponse(OrderEntity order);
}
