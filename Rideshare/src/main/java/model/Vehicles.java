package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="vehicles")
public class Vehicles {
    @Id
    //Not sure how to generate this
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(columnDefinition = "varchar(255)")
    private UUID VehicleID;
    private String Model;
    private String Brand;
    private String LicensePlate;
    private String VehicleType;
    private String Color;
    //Don't know if this is correct way of addressing this
    @OneToOne(mappedBy = "vehicles")
    private Users User;
    public Vehicles(String model, String brand, String licensePlate,String vehicleType, String color){
        this.Model=model;
        this.Brand=brand;
        this.LicensePlate=licensePlate;
        this.VehicleType=vehicleType;
        this.Color=color;
    }

//    public void setBrand(String brand) {
//        Brand = brand;
//    }
//
//    public void setColor(String color) {
//        Color = color;
//    }
//
//    public void setLicensePlate(String licensePlate) {
//        LicensePlate = licensePlate;
//    }
//
//    public void setModel(String model) {
//        Model = model;
//    }
//
//    public void setUser(Users user) {
//        User = user;
//    }
//
//    public void setVehicleType(String vehicleType) {
//        VehicleType = vehicleType;
//    }
//
//    public long getVehicleID() {
//        return VehicleID;
//    }
//
//    public String getBrand() {
//        return Brand;
//    }
//
//    public String getColor() {
//        return Color;
//    }
//
//    public String getLicensePlate() {
//        return LicensePlate;
//    }
//
//    public String getModel() {
//        return Model;
//    }
//
//    public String getVehicleType() {
//        return VehicleType;
//    }
//
//    public Users getUser() {
//        return User;
//    }
}
