package com.MacheNotas.MacheNotas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import com.MacheNotas.MacheNotas_api.model.entity.Periodo;

public interface PeriodoRepository extends JpaRepository<Periodo, Long> {

    Optional<Periodo> findByNombre(String  Nombre);

}
