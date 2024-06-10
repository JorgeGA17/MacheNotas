package com.MacheNotas.MacheNotas_api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Unidad")
@NoArgsConstructor
@AllArgsConstructor

public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "Nombre", nullable = false)
    private String nombre;
    @Column(name = "Duracion", nullable = false)
    private int duracion;
    @Column(name = "Creditaje", nullable = false)
    private int creditaje;
    @Column(name = "Calificacion", nullable = false)
    private double calificacion;
}
