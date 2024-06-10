package com.MacheNotas.MacheNotas_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PeriodoResponseDTO {
    private Long id;
    private String nombre;
    private LocalDate inicio;
    private LocalDate fin;

}
