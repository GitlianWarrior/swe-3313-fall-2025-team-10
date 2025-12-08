package com.revline.rare_cars_sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    // Get all available cars
    List<Car> findByIsSoldFalse();

    // Search Bar
    @Query("SELECT c FROM Car c WHERE c.isSold = false AND (" +
            "LOWER(c.make) LIKE LOWER(CONCAT('%', ?1, '%')) OR " +
            "LOWER(c.model) LIKE LOWER(CONCAT('%', ?1, '%')) OR " +
            "LOWER(c.description) LIKE LOWER(CONCAT('%', ?1, '%')))")
    List<Car> searchAvailableCars(String searchTerm);
}