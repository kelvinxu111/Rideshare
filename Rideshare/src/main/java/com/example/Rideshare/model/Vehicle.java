package com.example.Rideshare.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    //Not sure how to generate this
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "vehicleID", columnDefinition = "varchar(255)")
    private UUID vehicleID;

    @Column(name = "model",nullable = false)
    private String model;

    @Column(name = "brand",nullable = false)
    private String brand;

    @Column(name = "licensePlate",nullable = false)
    private String licensePlate;

    @Column(name = "vehicleType",nullable = false)
    private String vehicleType;

    @Column(name = "color",nullable = false)
    private String color;

    //Don't know if this is correct way of addressing this
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public Vehicle() {}

    public Vehicle(UUID vehicleID, String model, String brand, String licensePlate, String vehicleType, String color) {
        this.vehicleID = vehicleID;
        this.model = model;
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.color = color;
    }
}
