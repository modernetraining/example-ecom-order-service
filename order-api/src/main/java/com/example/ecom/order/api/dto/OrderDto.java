package com.example.ecom.order.api.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderDto {
    private String orderId;
    private Long customerId;
    private BigDecimal totalAmount;
    private List<OrderItemDto> items;

    public OrderDto() {
    }

    public OrderDto(String orderId, Long customerId, BigDecimal totalAmount, List<OrderItemDto> items) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }

    public static class OrderItemDto {
        private String productId;
        private Integer quantity;

        public OrderItemDto() {
        }

        public OrderItemDto(String productId, Integer quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
}
