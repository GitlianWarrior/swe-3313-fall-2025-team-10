package com.revline.rare_cars_sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

    List<Car> findByIsSoldFalse();

    List<Car> findByMake(String make);

    List<Car> findByPriceLessThan(double maxPrice);
}
