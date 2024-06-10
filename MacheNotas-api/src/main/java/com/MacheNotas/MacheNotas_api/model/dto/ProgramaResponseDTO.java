package com.MacheNotas.MacheNotas_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProgramaResponseDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private int duracion;

    // private Long unidadDidacticaId;
    // private Long periodoAcademicoId;


}
