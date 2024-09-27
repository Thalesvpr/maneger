package com.garage.maneger.maneger.modules.vehicle.dtos;

import lombok.Data;

@Data
public class VehicleUpdateDTO {
    private String name;
    private String type;
    private Long manufacturerId;
    private String description;
}
