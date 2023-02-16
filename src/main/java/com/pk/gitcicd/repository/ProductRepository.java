package com.pk.gitcicd.repository;

import com.pk.gitcicd.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
