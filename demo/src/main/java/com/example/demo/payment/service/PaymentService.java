package com.example.demo.payment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.payment.entity.Payment;
import com.example.demo.payment.repository.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Create payment
    public Payment createPayment(Payment payment) {

        payment.setStatus("SUCCESS");

        return paymentRepository.save(payment);
    }

    // Get all payments
    public List<Payment> getAllPayments() {

        return paymentRepository.findAll();
    }

    // Get payment by ID
    public Payment getPaymentById(Long id) {

        return paymentRepository.findById(id).orElse(null);
    }

    // Update payment
    public Payment updatePayment(Long id, Payment payment) {

        Payment existingPayment = paymentRepository.findById(id).orElse(null);

        if (existingPayment == null) {
            return null;
        }

        existingPayment.setOrderId(payment.getOrderId());
        existingPayment.setAmount(payment.getAmount());
        existingPayment.setStatus(payment.getStatus());

        return paymentRepository.save(existingPayment);
    }

    // Delete payment
    public void deletePayment(Long id) {

        paymentRepository.deleteById(id);
    }
}