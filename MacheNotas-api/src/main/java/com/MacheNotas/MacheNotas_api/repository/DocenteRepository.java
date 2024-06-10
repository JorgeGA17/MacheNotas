package com.MacheNotas.MacheNotas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MacheNotas.MacheNotas_api.model.entity.Docente;

import java.util.Optional;

public interface DocenteRepository extends JpaRepository<Docente, Long> {
    Optional<Docente> findByNombre(String nombre);
}
