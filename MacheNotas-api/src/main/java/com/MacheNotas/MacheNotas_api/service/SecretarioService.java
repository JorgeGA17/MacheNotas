package com.MacheNotas.MacheNotas_api.service;

import com.MacheNotas.MacheNotas_api.exception.ResourceNotFoundException;
import com.MacheNotas.MacheNotas_api.mapper.SecretarioMapper;
import com.MacheNotas.MacheNotas_api.model.dto.SecretarioRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.SecretarioResponseDTO;
import com.MacheNotas.MacheNotas_api.model.entity.Secretario;
import com.MacheNotas.MacheNotas_api.repository.SecretarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SecretarioService {

    private SecretarioRepository secretarioRepository;
    private SecretarioMapper secretarioMapper;

    @Transactional(readOnly = true)
    public List<SecretarioResponseDTO> getAllSecretarios() {
        List<Secretario> secretarios = secretarioRepository.findAll();
        return secretarioMapper.convertToListDTO(secretarios);
    }

    @Transactional(readOnly = true)
    public SecretarioResponseDTO getSecretarioById(Long id) {
        Secretario secretario = secretarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Secretario no encontrado" + id));
        return secretarioMapper.convertToDTO(secretario);
    }

    @Transactional
    public SecretarioResponseDTO createSecretario(SecretarioRequestDTO secretarioRequestDTO) {
        Secretario secretario = secretarioMapper.convertToEntity(secretarioRequestDTO);
        secretarioRepository.save(secretario);
        return secretarioMapper.convertToDTO(secretario);
    }

    @Transactional
    public SecretarioResponseDTO updateSecretario(Long id, SecretarioRequestDTO secretarioRequestDTO) {
        Secretario secretario = secretarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Secretario no encontrado" + id));
        secretario.setNombre(secretarioRequestDTO.getNombre());
        secretario.setEmail(secretarioRequestDTO.getEmail());
        secretario.setPassword(secretarioRequestDTO.getPassword());
        secretario = secretarioRepository.save(secretario);
        return secretarioMapper.convertToDTO(secretario);
    }

    @Transactional
    public void deleteSecretario(Long id) {
        secretarioRepository.deleteById(id);
    }
}