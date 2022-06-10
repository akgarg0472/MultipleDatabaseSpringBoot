package com.akgarg.multipledatabasespringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultipleDatabaseSpringBootApplication {

    private static final Logger logger = LoggerFactory.getLogger(MultipleDatabaseSpringBootApplication.class);

    public static void main(String[] args) {
        logger.info("Starting Multiple DB Spring Boot Application");
        SpringApplication.run(MultipleDatabaseSpringBootApplication.class, args);
        logger.info("Multiple DB Spring Boot Application started successfully");
    }

}
