package com.example.ecom.order.repository;

import com.example.ecom.order.model.Order;
import java.util.List;

public interface OrderRepositoryCustom {
    List<Order> findOrdersByCustomerId(Long customerId);
}
