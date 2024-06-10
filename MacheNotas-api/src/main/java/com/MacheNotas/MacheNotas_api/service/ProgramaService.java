package com.MacheNotas.MacheNotas_api.service;

import com.MacheNotas.MacheNotas_api.exception.ResourceNotFoundException;
import com.MacheNotas.MacheNotas_api.mapper.ProgramaMapper;
import com.MacheNotas.MacheNotas_api.model.dto.ProgramaRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.ProgramaResponseDTO;
import com.MacheNotas.MacheNotas_api.model.entity.Programa;
import com.MacheNotas.MacheNotas_api.repository.ProgramaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProgramaService {

    private ProgramaRepository programaRepository;
    private ProgramaMapper programaMapper;

    @Transactional(readOnly = true)
    public List<ProgramaResponseDTO> getAllProgramas() {
        List<Programa> programas = programaRepository.findAll();
        return programaMapper.convertToListDTO(programas);
    }

    @Transactional(readOnly = true)
    public ProgramaResponseDTO getProgramaById(Long id) {
        Programa programa = programaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Programa no encontrado" + id));
        return programaMapper.convertToDTO(programa);
    }

    @Transactional
    public ProgramaResponseDTO createPrograma(ProgramaRequestDTO programaRequestDTO) {
        Programa programa = programaMapper.convertToEntity(programaRequestDTO);
        programaRepository.save(programa);
        return programaMapper.convertToDTO(programa);
    }

    @Transactional
    public ProgramaResponseDTO updatePrograma(Long id, ProgramaRequestDTO programaRequestDTO) {
        Programa programa = programaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Programa no encontrado" + id));
        programa.setNombre(programaRequestDTO.getNombre());
        programa.setDescripcion(programaRequestDTO.getDescripcion());
        programa = programaRepository.save(programa);
        return programaMapper.convertToDTO(programa);
    }

    @Transactional
    public void deletePrograma(Long id) {
        programaRepository.deleteById(id);
    }
}