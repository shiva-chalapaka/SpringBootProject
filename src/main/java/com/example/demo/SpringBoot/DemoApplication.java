package com.example.demo.SpringBoot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // Preload sample data only if table is empty
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            if (repository.count() == 0) {  // only if no records
                repository.save(new Employee("Alice", "HR", 50000));
                repository.save(new Employee("Bob", "IT", 60000));
                repository.save(new Employee("Charlie", "Finance", 55000));
            }
        };
    }
}
