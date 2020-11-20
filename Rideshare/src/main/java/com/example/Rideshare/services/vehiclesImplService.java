package com.example.Rideshare.services;
import com.example.Rideshare.repository.vehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.Rideshare.model.*;
import java.util.List;
import java.util.UUID;
@Service("vehiclesService")
public class vehiclesImplService implements vehiclesService{
    @Autowired
    @Qualifier("vehiclesRepository")
    private vehiclesRepository vehicleRepository;

    @Override
    public Vehicles findVehicleByVehicleId(UUID id) {
        return vehicleRepository.findByVehicleId((id));
    }

    @Override
    public List<Vehicles> findVehiclesByModel(String model) {
        return vehicleRepository.findByModel(model);
    }

    @Override
    public List<Vehicles> findVehiclesByBrand(String brand) {
        return vehicleRepository.findByBrand(brand);
    }

    @Override
    public List<Vehicles> findVehiclesByLicensePlate(String licensePlate) {
        return vehicleRepository.findByLicensePlate(licensePlate);
    }

    @Override
    public List<Vehicles> findVehiclesByColor(String color) {
        return vehicleRepository.findByColor(color);
    }

    @Override
    public List<Vehicles> findVehiclesByUser(Users user) {
        return vehicleRepository.findByUser(user);
    }
    public Vehicles createVehicle(Vehicles vehicle,Users owner){
        Vehicles checkVehicles = findVehicleByVehicleId(vehicle.getVehicleID());
        if (checkVehicles!=null){
            return null;
        }
        vehicle.setUser(owner);
        vehicleRepository.save(vehicle);
        return vehicle;
    }
}
