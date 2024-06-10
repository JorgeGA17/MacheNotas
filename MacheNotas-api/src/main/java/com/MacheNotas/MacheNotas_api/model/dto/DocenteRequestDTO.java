package com.MacheNotas.MacheNotas_api.model.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DocenteRequestDTO {
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;
    @NotBlank(message = "El email no puede estar vacio")
    @Email
    private String email;
    @NotBlank(message = "El password no puede estar vacio")
    private String password;

}
