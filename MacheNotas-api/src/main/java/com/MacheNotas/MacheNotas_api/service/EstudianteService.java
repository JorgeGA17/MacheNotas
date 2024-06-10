package com.MacheNotas.MacheNotas_api.service;

import com.MacheNotas.MacheNotas_api.exception.ResourceNotFoundException;
import com.MacheNotas.MacheNotas_api.mapper.EstudianteMapper;
import com.MacheNotas.MacheNotas_api.model.dto.EstudianteRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.EstudianteResponseDTO;
import com.MacheNotas.MacheNotas_api.model.entity.Docente;
import com.MacheNotas.MacheNotas_api.model.entity.Estudiante;
import com.MacheNotas.MacheNotas_api.repository.EstudianteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor

public class EstudianteService {

    private EstudianteRepository estudianteRepository;
    private EstudianteMapper estudianteMapper;

    @Transactional(readOnly = true)
    public List<EstudianteResponseDTO> getAllEstudiantes() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudianteMapper.convertToListDTO(estudiantes);
    }

    @Transactional(readOnly = true)
    public EstudianteResponseDTO getEstudianteById(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado" + id));
        return estudianteMapper.convertToDTO(estudiante);
    }

    @Transactional
    public EstudianteResponseDTO createEstudiante(EstudianteRequestDTO estudianteRequestDTO) {
        Estudiante estudiante = estudianteMapper.convertToEntity(estudianteRequestDTO);
        estudianteRepository.save(estudiante);
        return estudianteMapper.convertToDTO(estudiante);
    }

    @Transactional
    public EstudianteResponseDTO updateEstudiante(Long id, EstudianteRequestDTO estudianteRequestDTO) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado" + id));
        estudiante.setNombre(estudianteRequestDTO.getNombre());
        estudiante.setEmail(estudianteRequestDTO.getEmail());
        estudiante.setPassword(estudianteRequestDTO.getPassword());
        estudiante = estudianteRepository.save(estudiante);
        return estudianteMapper.convertToDTO(estudiante);
    }

    @Transactional
    public void deleteEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }
}