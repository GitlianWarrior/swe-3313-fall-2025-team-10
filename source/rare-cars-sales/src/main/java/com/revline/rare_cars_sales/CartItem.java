package com.revline.rare_cars_sales;

import java.math.BigDecimal;

public class CartItem {

    private final Car car;
    private final int quantity;
    private final BigDecimal lineTotal;

    public CartItem(Car car, int quantity, BigDecimal lineTotal) {
        this.car = car;
        this.quantity = quantity;
        this.lineTotal = lineTotal;
    }

    public Car getCar() {
        return car;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getLineTotal() {
        return lineTotal;
    }
}