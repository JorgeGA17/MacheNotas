package com.MacheNotas.MacheNotas_api.repository;


import org.springframework.data.repository.CrudRepository;
import com.MacheNotas.MacheNotas_api.model.entity.Estudiante;

import java.util.Optional;

public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {

    Optional<Estudiante> findByNombre(String  Nombre);

}
