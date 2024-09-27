package com.garage.maneger.maneger.modules.vehicle.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private Long id;

    @NotBlank(message = "O nome do veículo é obrigatório.")
    private String name;

    @NotNull(message = "O tipo do veículo é obrigatório.")
    private String type;
}

