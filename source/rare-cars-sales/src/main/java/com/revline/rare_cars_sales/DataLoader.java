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
        loadUsers();
        loadInventory();
    }

    private void loadUsers() {
        //Create an ADMIN
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User(
                    "admin",
                    "admin123",
                    "Admin",
                    "User",
                    "admin@revline.com"
            );
            admin.setAdministrator(true); // Grant the superpower of being cooler than a normal user
            userRepository.save(admin);
            System.out.println("ADMIN ACCOUNT CREATED: Username: 'admin' | Password: 'admin123'");
        }

        //Create a NORMAL USER
        if (userRepository.findByUsername("user").isEmpty()) {
            User user = new User(
                    "user",
                    "user123",
                    "John",
                    "Doe",
                    "john@example.com"
            );
            userRepository.save(user); // Default isAdministrator = false
            System.out.println("TEST USER CREATED: Username: 'user' | Password: 'user123'");
        }
    }

    private void loadInventory() {
        // Only load if the database is empty
        if (carRepository.count() == 0) {

            // Car 1: Ferrari
            Car c1 = new Car(
                    "Ferrari",
                    "LaFerrari",
                    2015,
                    "The definition of a hypercar. Hybrid V12 engine producing nearly 1000hp.",
                    new BigDecimal("3200.00"),
                    "/static/images/ferrari.jpg"
            );

            // Car 2: Lamborghini
            Car c2 = new Car(
                    "Lamborghini",
                    "Centenario",
                    2017,
                    "Created to celebrate the 100th birthday of Ferruccio Lamborghini.",
                    new BigDecimal("2800.00"),
                    "/static/images/lambo.jpg"
            );

            // Car 3: Bugatti
            Car c3 = new Car(
                    "Bugatti",
                    "Chiron",
                    2020,
                    "The fastest production car in the world. Pure luxury and speed.",
                    new BigDecimal("3900.00"),
                    "/static/images/bugatti.jpg"
            );

            // Car 4: Porsche
            Car c4 = new Car(
                    "Porsche",
                    "911 GT3",
                    2022,
                    "A track weapon for the road.",
                    new BigDecimal("1200.00"),
                    "/static/images/porsche.jpg"
            );
            c4.setSold(true);

            carRepository.saveAll(List.of(c1, c2, c3, c4));
            System.out.println("INVENTORY STOCKED: 4 Cars Added (1 Sold)");
        }
    }
}