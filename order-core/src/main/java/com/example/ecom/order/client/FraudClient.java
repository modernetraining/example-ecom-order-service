package com.example.ecom.order.client;

import com.example.ecom.common.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

@FeignClient(name = "fraud-detection-service", url = "${fraud-detection-service.url:http://localhost:8087}", configuration = com.example.ecom.client.config.FeignClientConfig.class)
public interface FraudClient {

    @PostMapping("/api/fraud/check")
    ApiResponse<FraudCheckResponse> checkFraud(@RequestBody FraudCheckRequest request);

    class FraudCheckRequest {
        private Long customerId;
        private BigDecimal amount;

        public FraudCheckRequest(Long customerId, BigDecimal amount) {
            this.customerId = customerId;
            this.amount = amount;
        }

        public Long getCustomerId() {
            return customerId;
        }

        public BigDecimal getAmount() {
            return amount;
        }
    }

    class FraudCheckResponse {
        private String status;
        private String reason;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }
}
