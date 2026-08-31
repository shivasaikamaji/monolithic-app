package com.example.demo.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.order.entity.Order;
import com.example.demo.order.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Create order
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Get all orders
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    // Get order by ID
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // Update order
    public Order updateOrder(Long id, Order order) {

        Order existingOrder = orderRepository.findById(id).orElse(null);

        if (existingOrder == null) {
            return null;
        }

        existingOrder.setUserId(order.getUserId());
        existingOrder.setProductId(order.getProductId());
        existingOrder.setQuantity(order.getQuantity());

        return orderRepository.save(existingOrder);
    }

    // Delete order
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}