package com.tecma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecma.entities.Order;

public interface OrdersRepository extends JpaRepository<Order, Long> {

}
