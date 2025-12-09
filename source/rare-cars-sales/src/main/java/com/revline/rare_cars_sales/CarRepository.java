package com.revline.rare_cars_sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    // Get all "Available" cars for the shop
    List<Car> findByStatus(String status);

    // Search bar: search only available cars by name or description
    @Query("""
           SELECT c FROM Car c
           WHERE c.status = 'Available'
             AND (
                 LOWER(c.name)        LIKE LOWER(CONCAT('%', :term, '%'))
              OR LOWER(c.description) LIKE LOWER(CONCAT('%', :term, '%'))
             )
           """)
    List<Car> searchAvailableCars(@Param("term") String searchTerm);
}