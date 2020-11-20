package repository;
import model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.Vehicles;
import java.util.List;
import java.util.UUID;
@Repository("vehiclesRepository")
public interface vehiclesRepository extends JpaRepository{
    Vehicles findByVehicleId(UUID id);
    List<Vehicles> findByModel(String model);
    List<Vehicles> findByBrand(String brand);
    List<Vehicles> findByLicensePlate(String licensePlate);
    List<Vehicles> findByVehicleType(String vehicleType);
    List<Vehicles> findByColor(String color);
    List<Vehicles> findByUser(Users user);

}
