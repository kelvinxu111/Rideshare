package com.example.Rideshare.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "vehicles")
@Data
public class Vehicles {
    @Id
    //Not sure how to generate this
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "vehicleId", columnDefinition = "varchar(255)")
    private UUID VehicleId;
    @Column(name = "com/example/Rideshare/model", nullable = false)
    private String Model;
    @Column(name = "brand", nullable = false)
    private String Brand;
    @Column(name = "licensePlate", nullable = false)
    private String LicensePlate;
    @Column(name = "vehicleType", nullable = false)
    private String VehicleType;
    @Column(name = "color", nullable = false)
    private String Color;
    //Don't know if this is correct way of addressing this
    @ManyToOne(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
    @JoinColumn(name="users_id", nullable = false)
    private Users user;
    public Vehicles(){

    }
    public Vehicles(String model, String brand, String licensePlate, String vehicleType, String color) {
        this.Model = model;
        this.Brand = brand;
        this.LicensePlate = licensePlate;
        this.VehicleType = vehicleType;
        this.Color = color;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
    }

    public void setModel(String model) {
        Model = model;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public UUID getVehicleID() {
        return getVehicleID();
    }

    public String getBrand() {
        return Brand;
    }

    public String getColor() {
        return Color;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }

    public String getModel() {
        return Model;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public Users getUser() {
        return this.user;
    }
}
