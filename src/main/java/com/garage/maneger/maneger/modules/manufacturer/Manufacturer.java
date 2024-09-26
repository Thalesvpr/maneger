package com.garage.maneger.maneger.modules.manufacturer;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity(name = "manufacturers")
@Data
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
