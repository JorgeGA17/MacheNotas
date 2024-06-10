package com.MacheNotas.MacheNotas_api.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PeriodoRequestDTO {

    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    private LocalDate inicio;

    private LocalDate fin;

}
