package com.garage.maneger.maneger.modules.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> findById(Long id) {
        return vehicleRepository.findById(id);
    }

    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }

    public void update(Vehicle vehicle, Long id) {
        vehicle.setId(id);
        vehicleRepository.save(vehicle);
    }
}
