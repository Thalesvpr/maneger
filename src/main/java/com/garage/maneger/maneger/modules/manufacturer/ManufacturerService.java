package com.garage.maneger.maneger.modules.manufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    public Optional<Manufacturer> findById(Long id) {
        return manufacturerRepository.findById(id);
    }

    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    public void delete(Long id) {
        manufacturerRepository.deleteById(id);
    }
}
