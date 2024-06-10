package com.MacheNotas.MacheNotas_api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.MacheNotas.MacheNotas_api.model.entity.Estudiante;

import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    Optional<Estudiante> findByNombre(String  Nombre);

}
