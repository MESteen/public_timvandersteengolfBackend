package com.martijn.timvandersteenBackend.service.impl;

import com.martijn.timvandersteenBackend.dao.OrderDao;
import com.martijn.timvandersteenBackend.dao.UserDao;
import com.martijn.timvandersteenBackend.exception.ResourceNotFoundException;
import com.martijn.timvandersteenBackend.model.*;
import com.martijn.timvandersteenBackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Order save(OrderDto orderDto) {
        Order newOrder = orderDto.GetOrderFromDto();

        Set<OrderItem> orderItemsList = new HashSet<>();
        for(int i = 0; i < orderDto.getOrderItems().size(); i++){
            orderItemsList.add(orderDto.getOrderItems().get(i));
        }

        newOrder.setOrderItems(orderItemsList);
        return orderDao.save(newOrder);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderDao.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public Order findById(int orderId) {
        return orderDao.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));
    }

    @Override
    public void delete(Order order) {
        orderDao.delete(order);
    }
}
