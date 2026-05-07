package com.karthi.ecommerce_9.model.dto;

public record OrderItemRequest(
        int productId,
        int quantity
) {
}
