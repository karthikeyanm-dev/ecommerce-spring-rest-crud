package com.karthi.ecommerce_9.controller;

import com.karthi.ecommerce_9.model.Order;
import com.karthi.ecommerce_9.model.dto.OrderItemResponse;
import com.karthi.ecommerce_9.model.dto.OrderRequest;
import com.karthi.ecommerce_9.model.dto.OrderResponse;
import com.karthi.ecommerce_9.service.OrderService;
import jakarta.persistence.PostRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class OrderController {
// Place  Order

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders/place")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse orderResponse = orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

//  Get All Orders

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        List<OrderResponse> result = List.of(

                new OrderResponse(
                        "ORD1001",
                        "Karthikeyan",
                        "karthi@gmail.com",
                        "DELIVERED",
                        LocalDate.of(2026, 5, 1),
                        List.of(
                                new OrderItemResponse(
                                        "iPhone 15",
                                        1,
                                        new BigDecimal("79999")
                                ),
                                new OrderItemResponse(
                                        "Apple AirPods Pro",
                                        2,
                                        new BigDecimal("49998")
                                )
                        )
                ),

                new OrderResponse(
                        "ORD1002",
                        "Rahul Sharma",
                        "rahul@gmail.com",
                        "PENDING",
                        LocalDate.of(2026, 5, 3),
                        List.of(
                                new OrderItemResponse(
                                        "Samsung Galaxy S25",
                                        1,
                                        new BigDecimal("68999")
                                ),
                                new OrderItemResponse(
                                        "Wireless Charger",
                                        1,
                                        new BigDecimal("1999")
                                )
                        )
                ),

                new OrderResponse(
                        "ORD1003",
                        "Priya Menon",
                        "priya@gmail.com",
                        "SHIPPED",
                        LocalDate.of(2026, 5, 4),
                        List.of(
                                new OrderItemResponse(
                                        "HP Pavilion Laptop",
                                        1,
                                        new BigDecimal("65000")
                                ),
                                new OrderItemResponse(
                                        "Laptop Bag",
                                        1,
                                        new BigDecimal("1500")
                                ),
                                new OrderItemResponse(
                                        "Wireless Mouse",
                                        1,
                                        new BigDecimal("799")
                                )
                        )
                ),

                new OrderResponse(
                        "ORD1004",
                        "Arun Kumar",
                        "arun@gmail.com",
                        "CANCELLED",
                        LocalDate.of(2026, 5, 5),
                        List.of(
                                new OrderItemResponse(
                                        "Boat Rockerz Headphones",
                                        2,
                                        new BigDecimal("3998")
                                )
                        )
                )

        );
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}
