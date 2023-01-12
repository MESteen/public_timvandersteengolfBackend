package com.martijn.timvandersteenBackend.dao;

import com.martijn.timvandersteenBackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {
}
