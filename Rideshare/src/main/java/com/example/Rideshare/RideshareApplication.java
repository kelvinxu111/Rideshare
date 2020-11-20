package com.example.Rideshare;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"com/example/Rideshare/model"})
public class RideshareApplication {

	private static final Logger log = LoggerFactory.getLogger(RideshareApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(RideshareApplication.class, args);

    }

}
