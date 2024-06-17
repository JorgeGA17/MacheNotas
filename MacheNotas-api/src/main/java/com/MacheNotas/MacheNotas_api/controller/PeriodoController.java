package com.MacheNotas.MacheNotas_api.controller;

import com.MacheNotas.MacheNotas_api.model.dto.PeriodoRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.PeriodoResponseDTO;
import com.MacheNotas.MacheNotas_api.service.PeriodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Periodos")
@AllArgsConstructor
@CrossOrigin(originPatterns = "http://localhost:4200/")

public class PeriodoController {

    private final PeriodoService periodoService;

    @GetMapping
    public ResponseEntity<List<PeriodoResponseDTO>> getAllPeriodos() {
        List<PeriodoResponseDTO> periodos = periodoService.getAllPeriodos();
        return new ResponseEntity<>(periodos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodoResponseDTO> getPeriodoById(@PathVariable Long id) {
        PeriodoResponseDTO periodo = periodoService.getPeriodoById(id);
        return new ResponseEntity<>(periodo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PeriodoResponseDTO> createPeriodo(@Validated @RequestBody PeriodoRequestDTO periodoDTO) {
        PeriodoResponseDTO createdPeriodo = periodoService.createPeriodo(periodoDTO);
        return new ResponseEntity<>(createdPeriodo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeriodoResponseDTO> updatePeriodo(@PathVariable Long id, @Validated @RequestBody PeriodoRequestDTO periodoDTO) {
        PeriodoResponseDTO updatedPeriodo = periodoService.updatePeriodo(id, periodoDTO);
        return new ResponseEntity<>(updatedPeriodo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePeriodo(@PathVariable Long id) {
        periodoService.deletePeriodo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}