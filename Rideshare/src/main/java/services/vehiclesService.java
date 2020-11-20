package services;
import model.*;
import java.util.List;
import java.util.UUID;
public interface vehiclesService {
    public Vehicles findVehicleByVehicleId(UUID id);
    public List<Vehicles> findVehiclesByModel(String model);
    public List<Vehicles> findVehiclesByBrand(String brand);
    public List<Vehicles> findVehiclesByLicensePlate(String licensePlate);
    public List<Vehicles> findVehiclesByColor(String color);
    public List<Vehicles> findVehiclesByUser(Users user);
}
