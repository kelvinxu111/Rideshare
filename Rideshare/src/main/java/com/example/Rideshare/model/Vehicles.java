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
public class Vehicles {

    @Id
    //Not sure how to generate this
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "vehicleID", columnDefinition = "varchar(255)")
    private UUID vehicleID;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    @Column(name = "licensePlate")
    private String licensePlate;

    @Column(name = "vehicleType")
    private String vehicleType;

    @Column(name = "color")
    private String color;

    //Don't know if this is correct way of addressing this
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    public Vehicles() {}

    public Vehicles(UUID vehicleID, String model, String brand, String licensePlate, String vehicleType, String color) {
        this.vehicleID = vehicleID;
        this.model = model;
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.color = color;
    }
}
