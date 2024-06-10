package com.MacheNotas.MacheNotas_api.controller;

import com.MacheNotas.MacheNotas_api.model.dto.DocenteResponseDTO;
import com.MacheNotas.MacheNotas_api.model.dto.ProgramaRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.ProgramaResponseDTO;
import com.MacheNotas.MacheNotas_api.service.ProgramaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Programas")
@AllArgsConstructor
public class ProgramaController {
    private final ProgramaService programaService;

    @GetMapping
    public ResponseEntity<List<ProgramaResponseDTO>> getAllProgramas() {
        List<ProgramaResponseDTO> programas = programaService.getAllProgramas();
        return new ResponseEntity<>(programas, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProgramaResponseDTO> getProgramaById(@PathVariable Long id) {
        ProgramaResponseDTO programa = programaService.getProgramaById(id);
        return new ResponseEntity<>(programa, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProgramaResponseDTO> createPrograma(@Validated @RequestBody ProgramaRequestDTO programaDTO) {
        ProgramaResponseDTO createdPrograma = programaService.createPrograma(programaDTO);
        return new ResponseEntity<>(createdPrograma, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaResponseDTO> updatePrograma(@PathVariable Long id, @Validated @RequestBody ProgramaRequestDTO programaDTO) {
        ProgramaResponseDTO updatedPrograma = programaService.updatePrograma(id, programaDTO);
        return new ResponseEntity<>(updatedPrograma, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrograma(@PathVariable Long id) {
        programaService.deletePrograma(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}