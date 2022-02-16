package com.example.javaupskilling;

import com.example.javaupskilling.Repository.CustomerRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories (basePackageClasses = CustomerRepo.class)
public class JavaUpskillingApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaUpskillingApplication.class, args);
    }

}
