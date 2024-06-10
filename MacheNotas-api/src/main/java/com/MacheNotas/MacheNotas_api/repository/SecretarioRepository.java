package com.MacheNotas.MacheNotas_api.repository;
import com.MacheNotas.MacheNotas_api.model.entity.Secretario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecretarioRepository extends JpaRepository<Secretario, Long> {

    Optional<Secretario> findByNombre(String  Nombre);
}
