package com.MacheNotas.MacheNotas_api.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class PeriodoResponseDTO {
    private Long id;
    private String nombre;
    private Date inicio;
    private Date fin;

}
