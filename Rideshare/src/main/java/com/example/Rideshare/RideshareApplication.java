package com.example.Rideshare;
import com.example.Rideshare.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"com/example/Rideshare/model"})
public class RideshareApplication {

	public static void main(String[] args) {

		SpringApplication.run(RideshareApplication.class, args);

	}

}
