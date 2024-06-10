package com.MacheNotas.MacheNotas_api.repository;

import com.MacheNotas.MacheNotas_api.model.entity.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnidadRepository extends JpaRepository<Unidad, Long> {

    Optional<Unidad> findByNombre(String  Nombre);

}
