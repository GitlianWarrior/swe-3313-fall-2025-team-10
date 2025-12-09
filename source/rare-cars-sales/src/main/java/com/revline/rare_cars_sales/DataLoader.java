package com.revline.rare_cars_sales;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CarRepository carRepository;

    public DataLoader(UserRepository userRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User("admin", "admin123", "Admin", "User", "admin@revline.com");
            admin.setAdministrator(true);
            userRepository.save(admin);
            System.out.println("✅ ADMIN ACCOUNT CREATED");
        }
        if (userRepository.findByUsername("user").isEmpty()) {
            User user = new User("user", "user123", "John", "Doe", "john@example.com");
            userRepository.save(user);
            System.out.println("✅ TEST USER CREATED");
        }
        if (carRepository.count() == 0) {
            Car c1 = new Car("Ferrari", "LaFerrari", 2015, "Hybrid V12 engine.", new BigDecimal("3200.00"), "/images/ferrari.jpg");
            Car c2 = new Car("Lamborghini", "Centenario", 2017, "Celebration model.", new BigDecimal("2800.00"), "/images/lambo.jpg");
            Car c3 = new Car("Bugatti", "Chiron", 2020, "Fastest production car.", new BigDecimal("3900.00"), "/images/bugatti.jpg");
            Car c4 = new Car("Porsche", "911 GT3", 2022, "Track weapon.", new BigDecimal("1200.00"), "/images/porsche.jpg");
            c4.setSold(true);
            carRepository.saveAll(List.of(c1, c2, c3, c4));
            System.out.println("✅ INVENTORY STOCKED");
        }
    }
}