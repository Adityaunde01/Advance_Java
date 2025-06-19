package com.crudrest.dayEleven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.crudrest.dayEleven")
@EnableJpaRepositories(basePackages = "com.crudrest.dayEleven.repository")
@EntityScan(basePackages = {"com.crudrest.dayEleven.entity"})
public class DayElevenApplication {
    public static void main(String[] args) {
        SpringApplication.run(DayElevenApplication.class, args);
    }
}

