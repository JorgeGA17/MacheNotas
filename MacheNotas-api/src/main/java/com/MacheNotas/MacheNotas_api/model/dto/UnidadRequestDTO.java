package com.MacheNotas.MacheNotas_api.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UnidadRequestDTO {

    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    private int duracion;

    private int creditaje;

    private double calificacion;

}
