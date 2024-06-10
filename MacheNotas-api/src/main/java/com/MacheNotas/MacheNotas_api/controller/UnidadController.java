package com.MacheNotas.MacheNotas_api.controller;

import com.MacheNotas.MacheNotas_api.model.dto.UnidadRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.UnidadResponseDTO;
import com.MacheNotas.MacheNotas_api.service.UnidadService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Unidades")
@AllArgsConstructor
public class UnidadController {
    private final UnidadService unidadService;

    @GetMapping
    public ResponseEntity<List<UnidadResponseDTO>> getAllUnidades() {
        List<UnidadResponseDTO> unidades = unidadService.getAllUnidades();
        return new ResponseEntity<>(unidades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadResponseDTO> getUnidadById(@PathVariable Long id) {
        UnidadResponseDTO unidad = unidadService.getUnidadById(id);
        return new ResponseEntity<>(unidad, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UnidadResponseDTO> createUnidad(@Validated @RequestBody UnidadRequestDTO unidadDTO) {
        UnidadResponseDTO createdUnidad = unidadService.createUnidad(unidadDTO);
        return new ResponseEntity<>(createdUnidad, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadResponseDTO> updateUnidad(@PathVariable Long id, @Validated @RequestBody UnidadRequestDTO unidadDTO) {
        UnidadResponseDTO updatedUnidad = unidadService.updateUnidad(id, unidadDTO);
        return new ResponseEntity<>(updatedUnidad, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnidad(@PathVariable Long id) {
        unidadService.deleteUnidad(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}