package com.example.Rideshare.repository;
import com.example.Rideshare.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface VehicleRepository extends JpaRepository<Vehicle,UUID>{
    Vehicle findByVehicleID(UUID id);
    List<Vehicle> findByModel(String model);
    List<Vehicle> findByBrand(String brand);
    List<Vehicle> findByLicensePlate(String licensePlate);
    List<Vehicle> findByVehicleType(String vehicleType);
    List<Vehicle> findByColor(String color);
    List<Vehicle> findByUser(User user);

}
