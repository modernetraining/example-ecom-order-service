package com.example.ecom.order.client;

import com.example.ecom.common.dto.ApiResponse;
import com.example.ecom.order.api.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "order-service", url = "${order-service.url:http://localhost:8082}", configuration = com.example.ecom.client.config.FeignClientConfig.class)
public interface OrderClient {

    @PostMapping("/api/orders")
    ApiResponse<OrderDto> createOrder(@RequestBody OrderDto orderDto);
}
