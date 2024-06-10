package com.MacheNotas.MacheNotas_api.controller;

import com.MacheNotas.MacheNotas_api.model.dto.SecretarioRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.SecretarioResponseDTO;
import com.MacheNotas.MacheNotas_api.service.SecretarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Secretarios")
@AllArgsConstructor
public class SecretarioController {
    private final SecretarioService secretarioService;

    @GetMapping
    public ResponseEntity<List<SecretarioResponseDTO>> getAllSecretarios() {
        List<SecretarioResponseDTO> secretarios = secretarioService.getAllSecretarios();
        return new ResponseEntity<>(secretarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SecretarioResponseDTO> getSecretarioById(@PathVariable Long id) {
        SecretarioResponseDTO secretario = secretarioService.getSecretarioById(id);
        return new ResponseEntity<>(secretario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SecretarioResponseDTO> createSecretario(@Validated @RequestBody SecretarioRequestDTO secretarioDTO) {
        SecretarioResponseDTO createdSecretario = secretarioService.createSecretario(secretarioDTO);
        return new ResponseEntity<>(createdSecretario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SecretarioResponseDTO> updateSecretario(@PathVariable Long id, @Validated @RequestBody SecretarioRequestDTO secretarioDTO) {
        SecretarioResponseDTO updatedSecretario = secretarioService.updateSecretario(id, secretarioDTO);
        return new ResponseEntity<>(updatedSecretario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSecretario(@PathVariable Long id) {
        secretarioService.deleteSecretario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}