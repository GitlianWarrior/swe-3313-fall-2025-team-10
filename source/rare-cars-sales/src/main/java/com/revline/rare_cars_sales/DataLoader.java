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
            User admin = new User("admin", "admin123", "admin", "admin", "revlineadmin@gmail.com");
            admin.setAdministrator(true);
            userRepository.save(admin);
            System.out.println("ADMIN ACCOUNT CREATED");
        }
        // ONLY stock if empty
        if (carRepository.count() == 0) {
            // Note: Updated paths to /files/ to match the ImageController
            Car c1 = new Car("Porsche", "911", 2020, "Luxury sport", new BigDecimal("98750.00"), "/files/porsche9112020.jpg");
            Car c2 = new Car("Lamborghini", "Aventador", 2015, "Super sport", new BigDecimal("519999"), "/files/lamborghiniaventador2015.jpg");
            Car c3 = new Car("Ferrari", "F40", 1987, "Classic", new BigDecimal("2500000"), "/files/ferrarif401987.jpg");
            Car c4 = new Car("Bugatti", "Chiron", 2022, "Exotic sport", new BigDecimal("3300000"), "/files/bugattichiron2022.jpg");
            Car c5 = new Car("Mclaren", "Speed tail", 2021, "Hyper sport", new BigDecimal("2000000"), "/files/mclarenspeedtail2021.jpg");
            carRepository.saveAll(List.of(c1, c2, c3, c4, c5));
            System.out.println("INVENTORY STOCKED");
        }
    }
}
