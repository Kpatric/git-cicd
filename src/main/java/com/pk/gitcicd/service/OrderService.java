package com.pk.gitcicd.service;

import com.pk.gitcicd.model.Order;
import com.pk.gitcicd.model.Product;
import com.pk.gitcicd.repository.OrderRepository;
import com.pk.gitcicd.repository.ProductRepository;
import com.pk.gitcicd.utils.ResouceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order createOrder(Order order) {
        List<Product> products = order.getProducts();
        for (Product product : products) {
            Product existingProduct = productRepository.findById(product.getId()).orElse(null);
            if (existingProduct == null) {
                throw new ResouceNotFoundException("Product with id " + product.getId() + " not found.");
            }
            existingProduct.setStock(existingProduct.getStock() - 1);
            productRepository.save(existingProduct);
        }
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }
}

