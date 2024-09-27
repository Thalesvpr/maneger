package com.garage.maneger.maneger.modules.manufacturer.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerDTO {
    private Long id;

    @NotBlank(message = "O nome do fabricante é obrigatório.")
    private String name;
}
