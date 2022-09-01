package com.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}
