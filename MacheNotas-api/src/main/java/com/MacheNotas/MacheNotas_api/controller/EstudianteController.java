package com.MacheNotas.MacheNotas_api.controller;

import com.MacheNotas.MacheNotas_api.model.dto.EstudianteRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.EstudianteResponseDTO;
import com.MacheNotas.MacheNotas_api.service.DocenteService;
import com.MacheNotas.MacheNotas_api.service.EstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Estudiantes")
@AllArgsConstructor

public class EstudianteController {

    private final EstudianteService estudianteService;

    @GetMapping
    public ResponseEntity<List<EstudianteResponseDTO>> getAllEstudiantes() {
        List<EstudianteResponseDTO> estudiantes = estudianteService.getAllEstudiantes();
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteResponseDTO> getEstudianteById(@PathVariable Long id) {
        EstudianteResponseDTO estudiante = estudianteService.getEstudianteById(id);
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EstudianteResponseDTO> createEstudiante(@Validated @RequestBody EstudianteRequestDTO estudianteDTO) {
        EstudianteResponseDTO createdEstudiante = estudianteService.createEstudiante(estudianteDTO);
        return new ResponseEntity<>(createdEstudiante, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteResponseDTO> updateEstudiante(@PathVariable Long id, @Validated @RequestBody EstudianteRequestDTO estudianteDTO) {
        EstudianteResponseDTO updatedEstudiante = estudianteService.updateEstudiante(id, estudianteDTO);
        return new ResponseEntity<>(updatedEstudiante, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id) {
        estudianteService.deleteEstudiante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}