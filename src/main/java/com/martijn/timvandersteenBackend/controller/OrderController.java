package com.martijn.timvandersteenBackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.martijn.timvandersteenBackend.model.*;
import com.martijn.timvandersteenBackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public String getAllPartners() throws JsonProcessingException {
        List<Order> list = orderService.findAll();
        String gson = new Gson().toJson(list);
        return gson;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/add")
    public Order createOrder(@RequestBody String order) {
        OrderDto addOrder = new Gson().fromJson( order, OrderDto.class );
        return orderService.save(addOrder);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable(value = "id") int orderId) {
        Order returnVal = orderService.findById(orderId);
        return returnVal;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable(value = "id") int orderId) {
        Order order = orderService.findById(orderId);

        orderService.delete(order);
        return ResponseEntity.ok().build();
    }
}
