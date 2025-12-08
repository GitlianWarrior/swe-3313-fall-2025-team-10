package com.revline.rare_cars_sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Login and Registration checks
    Optional<User> findByUsername(String username);
}