package com.revline.rare_cars_sales;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import java.util.List;
import java.math.BigDecimal;

@Entity
@Table(name = "shopping_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private BigDecimal subTotal;

    @Column(nullable = false)
    private BigDecimal tax;

    @Column(nullable = false)
    private BigDecimal shippingFee;

    @Column(nullable = false)
    private BigDecimal total;

    @Column(nullable = false) private String shippingAddressStreet;
    @Column(nullable = false) private String shippingAddressCity;
    @Column(nullable = false) private String shippingAddressState;
    @Column(nullable = false) private String shippingAddressZip;
    @Column(nullable = false) private String paymentCardLastFour;
    @Column(nullable = false) private String phone;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    protected Order() {}

    public Order(User user, BigDecimal subTotal, BigDecimal tax, BigDecimal shippingFee, BigDecimal total, String shippingAddressStreet, String shippingAddressCity, String shippingAddressState, String shippingAddressZip, String paymentCardLastFour, String phone) {
        this.user = user;
        this.subTotal = subTotal;
        this.tax = tax;
        this.shippingFee = shippingFee;
        this.total = total;
        this.shippingAddressStreet = shippingAddressStreet;
        this.shippingAddressCity = shippingAddressCity;
        this.shippingAddressState = shippingAddressState;
        this.shippingAddressZip = shippingAddressZip;
        this.paymentCardLastFour = paymentCardLastFour;
        this.phone = phone;
    }

    public Long getOrderID() { return orderID; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }
    public BigDecimal getSubTotal() { return subTotal; }
    public void setSubTotal(BigDecimal subTotal) { this.subTotal = subTotal; }
    public BigDecimal getTax() { return tax; }
    public void setTax(BigDecimal tax) { this.tax = tax; }
    public BigDecimal getShippingFee() { return shippingFee; }
    public void setShippingFee(BigDecimal shippingFee) { this.shippingFee = shippingFee; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
    public List<OrderItem> getOrderItems() { return orderItems; }
    public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }
    public String getShippingAddressStreet() { return shippingAddressStreet; }
    public String getShippingAddressCity() { return shippingAddressCity; }
    public String getShippingAddressState() { return shippingAddressState; }
    public String getShippingAddressZip() { return shippingAddressZip; }
    public String getPaymentCardLastFour() { return paymentCardLastFour; }
    public String getPhone() { return phone; }
}