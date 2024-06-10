package com.MacheNotas.MacheNotas_api.mapper;

import com.MacheNotas.MacheNotas_api.model.dto.PeriodoRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.PeriodoResponseDTO;
import com.MacheNotas.MacheNotas_api.model.dto.ProgramaRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.ProgramaResponseDTO;
import com.MacheNotas.MacheNotas_api.model.entity.Programa;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
@AllArgsConstructor

public class ProgramaMapper {

    private final ModelMapper modelMapper;

    public Programa convertToEntity(ProgramaRequestDTO programaRequestDTO) {
        return modelMapper.map(programaRequestDTO, Programa.class);
    }

    public ProgramaResponseDTO convertToDTO(Programa programa) {
        return modelMapper.map(programa, ProgramaResponseDTO.class);
    }

    public List<ProgramaResponseDTO> convertToListDTO(List<Programa> programas) {

        return programas.stream()
                .map(this::convertToDTO)
                .toList();
    }

}
