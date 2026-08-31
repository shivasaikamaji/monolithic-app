package com.example.demo.product.service;

import com.example.demo.product.entity.Product;
import com.example.demo.product.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // CREATE product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // GET all products
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // GET product by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Product not found with id: " + id
                        )
                );
    }

    // UPDATE product
    public Product updateProduct(Long id, Product product) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Product not found with id: " + id
                        )
                );

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());

        return productRepository.save(existingProduct);
    }

    // DELETE product
    public void deleteProduct(Long id) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Product not found with id: " + id
                        )
                );

        productRepository.delete(existingProduct);
    }
}