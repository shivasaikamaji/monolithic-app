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

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order order) {

        Order existingOrder = orderRepository.findById(id).orElse(null);

        if (existingOrder == null) {
            return null;
        }

        existingOrder.setUserId(order.getUserId());
        existingOrder.setProductId(order.getProductId());
        existingOrder.setQuantity(order.getQuantity());
        existingOrder.setTotalPrice(order.getTotalPrice());

        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}