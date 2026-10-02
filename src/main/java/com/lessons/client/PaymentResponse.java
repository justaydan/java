package com.lessons.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentResponse {
    private String transactionId;
    private String status;
    private String message;

    public static PaymentResponse failed(String message) {
        return new PaymentResponse(null, "FAILED", message);
    }
}
