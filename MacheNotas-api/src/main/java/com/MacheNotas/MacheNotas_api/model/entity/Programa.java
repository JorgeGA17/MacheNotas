package com.MacheNotas.MacheNotas_api.model.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Programa")
@NoArgsConstructor
@AllArgsConstructor

public class Programa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "Nombre", nullable = false)
    private String nombre;
    @Column(name = "Descripcion", nullable = false)
    private String descripcion;
    @Column(name = "Duracion", nullable = false)
    private int duracion;

/*    @ManyToOne
    @JoinColumn(name = "unidad_didactica_id")
    private Unidad unidad;


    @ManyToOne
    @JoinColumn(name = "periodo_academico_id")
    private Periodo periodo;
*/

}
