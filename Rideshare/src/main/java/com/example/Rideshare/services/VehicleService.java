package com.example.Rideshare.services;
import com.example.Rideshare.model.*;
import java.util.List;
import java.util.UUID;
public interface VehicleService {
    public Vehicle findVehicleByVehicleId(UUID id);
    public List<Vehicle> findVehiclesByModel(String model);
    public List<Vehicle> findVehiclesByBrand(String brand);
    public List<Vehicle> findVehiclesByLicensePlate(String licensePlate);
    public List<Vehicle> findVehiclesByColor(String color);
    public List<Vehicle> findVehiclesByUser(User user);
}
