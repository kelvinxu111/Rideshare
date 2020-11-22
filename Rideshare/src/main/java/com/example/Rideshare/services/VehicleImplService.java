package com.example.Rideshare.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.Rideshare.model.*;
import com.example.Rideshare.repository.*;


import java.util.List;
import java.util.UUID;
@Service("vehiclesService")
public class VehicleImplService implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle findVehicleByVehicleId(UUID id) {
        return vehicleRepository.findByVehicleID((id));
    }

    @Override
    public List<Vehicle> findVehiclesByModel(String model) {
        return vehicleRepository.findByModel(model);
    }

    @Override
    public List<Vehicle> findVehiclesByBrand(String brand) {
        return vehicleRepository.findByBrand(brand);
    }

    @Override
    public List<Vehicle> findVehiclesByLicensePlate(String licensePlate) {
        return vehicleRepository.findByLicensePlate(licensePlate);
    }

    @Override
    public List<Vehicle> findVehiclesByColor(String color) {
        return vehicleRepository.findByColor(color);
    }

    @Override
    public List<Vehicle> findVehiclesByUser(User user) {
        return vehicleRepository.findByUser(user);
    }
    public Vehicle createVehicle(Vehicle vehicle, User owner){
        Vehicle checkVehicles = findVehicleByVehicleId(vehicle.getVehicleID());
        if (checkVehicles!=null){
            return null;
        }
        vehicle.setUser(owner);
        vehicleRepository.save(vehicle);
        return vehicle;
    }
}
