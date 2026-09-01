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

    // CREATE ORDER
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // GET ALL ORDERS
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // GET ORDER BY ID
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    // UPDATE ORDER
    public Order updateOrder(Long id, Order order) {

        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        existingOrder.setProductName(order.getProductName());
        existingOrder.setQuantity(order.getQuantity());
        existingOrder.setPrice(order.getPrice());

        return orderRepository.save(existingOrder);
    }

    // DELETE ORDER
    public void deleteOrder(Long id) {

        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found with id: " + id);
        }

        orderRepository.deleteById(id);
    }
}