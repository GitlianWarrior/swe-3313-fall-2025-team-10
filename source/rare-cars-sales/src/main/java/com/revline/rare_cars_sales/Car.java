package com.revline.rare_cars_sales;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carID;

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private String imagePath;

    @Column(nullable = false)
    private boolean isSold = false;

    protected Car() {}

    public Car(String make, String model, int year, String description, BigDecimal price, String imagePath) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
        this.isSold = false;
    }

    public Long getCarID() { return carID; }
    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public boolean isSold() { return isSold; }
    public void setSold(boolean sold) { isSold = sold; }
}
