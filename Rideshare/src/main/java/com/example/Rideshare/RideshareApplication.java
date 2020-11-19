package com.example.Rideshare;
import model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"model"})
public class RideshareApplication {

	public static void main(String[] args) {
		SpringApplication.run(RideshareApplication.class, args);
	}

}
