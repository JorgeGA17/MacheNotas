package com.MacheNotas.MacheNotas_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UnidadRequestDTO {
    private String nombre;
    private int duracion;
    private int creditaje;
    private double calificacion;

}
