package com.revline.rare_cars_sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    // Main Page (Show available inventory)
    List<Car> findByIsSoldFalse();

    // Search Bar
    List<Car> findByIsSoldFalseAndMakeContainingIgnoreCaseOrModelContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String make, String model, String description
    );
}
