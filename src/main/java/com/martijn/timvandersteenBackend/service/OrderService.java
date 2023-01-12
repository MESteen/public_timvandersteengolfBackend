package com.martijn.timvandersteenBackend.service;

import com.martijn.timvandersteenBackend.model.*;

import java.util.List;


public interface OrderService {

    Order save(OrderDto order);

    Order updateOrder(Order order);

    List<Order> findAll();

    Order findById(int orderId);

    void delete(Order order);
}
