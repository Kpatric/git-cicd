package com.pk.gitcicd.repository;

import com.pk.gitcicd.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
