package com.smolano.createuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class CreateUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreateUserApplication.class, args);
    }

}
