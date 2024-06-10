package com.MacheNotas.MacheNotas_api.mapper;


import com.MacheNotas.MacheNotas_api.model.dto.EstudianteRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.EstudianteResponseDTO;
import com.MacheNotas.MacheNotas_api.model.entity.Estudiante;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@AllArgsConstructor

public class EstudianteMapper {
    private final ModelMapper modelMapper;

    public Estudiante convertToEntity(EstudianteRequestDTO estudianteRequestDTO) {
        return modelMapper.map(estudianteRequestDTO, Estudiante.class);
    }

    public EstudianteResponseDTO convertToDTO(Estudiante estudiante) {
        return modelMapper.map(estudiante, EstudianteResponseDTO.class);
    }

    public List<EstudianteResponseDTO> convertToListDTO(List<Estudiante> estudiantes) {

        return estudiantes.stream()
                .map(this::convertToDTO)
                .toList();
    }

}
