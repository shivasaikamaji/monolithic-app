package com.example.demo.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class orderController {

    @GetMapping("/orders")
    public String getOrders() {
        return "Order module is working";
    }
}