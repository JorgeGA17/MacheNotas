package com.MacheNotas.MacheNotas_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecretarioResponseDTO {
    private Long id;
    private String nombre;
    private String email;

}
