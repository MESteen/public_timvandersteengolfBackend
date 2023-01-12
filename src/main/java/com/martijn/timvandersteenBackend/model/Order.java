package com.martijn.timvandersteenBackend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Orders") //order met s want db doet raar
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @NotNull
    @Column(name = "user_id")
    private int userId;

    @Column(name = "created_datum")
    private Date createdDatum;

    @Column(name = "total_price")
    private Double totalPrice;

    @OneToMany(cascade = CascadeType.ALL) //remove mappedBy
    @JoinTable(name = "ORDER_PRODUCTS",
            joinColumns =  @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private Set<OrderItem> orderItems;

    public Order() {
    }

    public Order(OrderDto orderDto){
        this.userId = userId;
        this.createdDatum = new Date();
        this.totalPrice = orderDto.GetTotalPrice();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreatedDatum() {
        return createdDatum;
    }

    public void setCreatedDatum(Date createdDatum) {
        this.createdDatum = createdDatum;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
