package com.MacheNotas.MacheNotas_api.repository;

import com.MacheNotas.MacheNotas_api.model.entity.Programa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgramaRepository extends JpaRepository<Programa, Long> {

    Optional<Programa> findByNombre(String  Nombre);


}
