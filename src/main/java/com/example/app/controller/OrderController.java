package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.dto.request.CreateOrderRequest;
import com.example.app.dto.response.OrderResponse;
import com.example.app.services.OrderService;

@RestController
@RequestMapping("order-management")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<OrderResponse> calculate(@RequestBody CreateOrderRequest request) {
        return orderService.calculate(request);
    }
}
