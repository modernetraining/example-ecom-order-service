package com.example.ecom.order.controller;

import com.example.ecom.common.dto.ApiResponse;
import com.example.ecom.order.api.dto.OrderDto;
import com.example.ecom.order.model.Order;
import com.example.ecom.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private com.example.ecom.order.client.FraudClient fraudClient;

    @Autowired
    private org.springframework.amqp.rabbit.core.RabbitTemplate rabbitTemplate;

    @PostMapping
    public ApiResponse<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        // Fraud Check
        com.example.ecom.order.client.FraudClient.FraudCheckRequest fraudRequest = new com.example.ecom.order.client.FraudClient.FraudCheckRequest(
                orderDto.getCustomerId(), orderDto.getTotalAmount());

        ApiResponse<com.example.ecom.order.client.FraudClient.FraudCheckResponse> fraudResponse = fraudClient
                .checkFraud(fraudRequest);

        if (fraudResponse.getData() != null && "BLOCKED".equals(fraudResponse.getData().getStatus())) {
            return ApiResponse.error("Order blocked: " + fraudResponse.getData().getReason());
        }

        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString());
        order.setCustomerId(orderDto.getCustomerId());
        order.setTotalAmount(orderDto.getTotalAmount());
        // Map items... simplified for demo

        orderRepository.save(order);
        orderDto.setOrderId(order.getOrderId());

        // Publish OrderCreatedEvent
        com.example.ecom.common.event.OrderCreatedEvent event = new com.example.ecom.common.event.OrderCreatedEvent();
        event.setOrderId(order.getOrderId());
        event.setCustomerId(order.getCustomerId());
        event.setTotalAmount(order.getTotalAmount());
        // Map items if necessary, for now sending empty items or mapping if available
        // event.setItems(...)

        rabbitTemplate.convertAndSend(com.example.ecom.order.config.RabbitMQConfig.EXCHANGE_NAME, "order.created",
                event);

        return ApiResponse.success(orderDto);
    }

    @GetMapping("/{id}")
    public ApiResponse<Order> getOrder(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(ApiResponse::success)
                .orElse(ApiResponse.error("Order not found"));
    }
}
