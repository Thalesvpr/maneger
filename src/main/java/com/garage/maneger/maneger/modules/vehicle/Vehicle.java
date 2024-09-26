package com.garage.maneger.maneger.modules.vehicle;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import com.garage.maneger.maneger.modules.manufacturer.Manufacturer;

@Entity(name = "vehicle")
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    private String description;

    private String image;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}

enum VehicleType {
    CAR, MOTORCYCLE
}
