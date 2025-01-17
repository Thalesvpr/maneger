package com.garage.maneger.maneger.modules.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.garage.maneger.maneger.modules.manufacturer.Manufacturer;
import com.garage.maneger.maneger.modules.manufacturer.ManufacturerService;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping
    public String listVehicles(Model model) {
        model.addAttribute("vehicles", vehicleService.findAll());
        return "vehicle/vehicles";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("manufacturers", manufacturerService.findAll());
        return "vehicle/vehicle_form";
    }

    @PostMapping("/save")
    public String saveVehicle(@ModelAttribute Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("vehicle", vehicleService.findById(id).orElseThrow());
        model.addAttribute("manufacturers", manufacturerService.findAll());
        return "vehicle/vehicle_form";
    }

    @PostMapping("/update/{id}")
    public String updateManufacturer(@PathVariable Long id, @ModelAttribute Vehicle vehicle) {
        vehicleService.update(vehicle, id);
        return "redirect:/vehicles";
    }

    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        vehicleService.delete(id);
        return "redirect:/vehicles";
    }
}

