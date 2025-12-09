package com.revline.rare_cars_sales;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemID;

    @ManyToOne(optional = false)
    @JoinColumn(name = "orderID", nullable = false)
    private Order order;

    @OneToOne(optional = false)
    @JoinColumn(name = "carID", nullable = false, unique = true)
    private Car car;

    protected OrderItem() {}

    public OrderItem(Car car, Order order) {
        this.car = car;
        this.order = order;
    }

    public Long getOrderItemID() { return orderItemID; }
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }
}