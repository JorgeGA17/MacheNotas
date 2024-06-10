package com.MacheNotas.MacheNotas_api.model.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Periodo")
@NoArgsConstructor
@AllArgsConstructor

public class Periodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;
    @Column(name = "Inicio", nullable = false)
    private String inicio;
    @Column(name = "Fin", nullable = false)
    private String fin;

}
