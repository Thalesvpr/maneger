package com.garage.maneger.maneger.modules.manufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping
    public String listManufacturers(Model model) {
        model.addAttribute("manufacturers", manufacturerService.findAll());
        return "manufacturer/manufactures";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "manufacturer/manufacture_form";
    }

    @PostMapping("/save")
    public String saveManufacturer(@ModelAttribute Manufacturer manufacturer) {
        manufacturerService.save(manufacturer);
        return "redirect:/manufacturers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("manufacturer", manufacturerService.findById(id).orElseThrow());
        return "manufacturer/manufacture_form";
    }

    @PutMapping("/update/{id}")
    public String updateManufacturer(@PathVariable Long id, @ModelAttribute Manufacturer manufacturer) {
        manufacturerService.update(manufacturer, id);
        return "redirect:/manufacturers";
    }

    @GetMapping("/delete/{id}")
    public String deleteManufacturer(@PathVariable Long id) {
        manufacturerService.delete(id);
        return "redirect:/manufacturers";
    }
}
