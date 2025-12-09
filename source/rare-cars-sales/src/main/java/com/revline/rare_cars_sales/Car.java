package com.revline.rare_cars_sales;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column
    private String image;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String status = "Available";

    // Constructors

    protected Car() {

    }

    public Car(String name, Double price, String image, String description, String status) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
        this.status = status;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
