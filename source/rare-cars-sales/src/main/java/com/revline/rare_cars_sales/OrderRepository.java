package com.revline.rare_cars_sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Admin Sales Report
    List<Order> findAllByOrderByOrderDateDesc();
}

//hello

