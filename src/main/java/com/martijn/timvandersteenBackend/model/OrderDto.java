package com.martijn.timvandersteenBackend.model;

import java.util.Date;
import java.util.List;

public class OrderDto {

    private int userId;

    private List<OrderItem> orderItems;

    public double GetTotalPrice(){
        double totalPrice = 0.00;

        for(int i = 0; i < this.orderItems.size(); i++){
            totalPrice = totalPrice + this.orderItems.get(i).getPrice();
        }

        return totalPrice;
    }

    public Order GetOrderFromDto(){
        Order order = new Order();
        order.setUserId(this.userId);
        order.setCreatedDatum(new Date());
        order.setTotalPrice(this.GetTotalPrice());

        return order;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
