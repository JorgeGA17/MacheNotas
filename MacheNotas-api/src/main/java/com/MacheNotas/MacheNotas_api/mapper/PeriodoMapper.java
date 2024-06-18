package com.MacheNotas.MacheNotas_api.mapper;


import com.MacheNotas.MacheNotas_api.model.dto.PeriodoRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.PeriodoResponseDTO;
import com.MacheNotas.MacheNotas_api.model.entity.Periodo;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component

public class PeriodoMapper {

    private final ModelMapper modelMapper;

    public Periodo convertToEntity(PeriodoRequestDTO periodoRequestDTO) {
        return modelMapper.map(periodoRequestDTO, Periodo.class);
    }

    public PeriodoResponseDTO convertToDTO(Periodo periodo) {
        return modelMapper.map(periodo, PeriodoResponseDTO.class);
    }

    public List<PeriodoResponseDTO> convertToListDTO(List<Periodo> periodos) {

        return periodos.stream()
                .map(this::convertToDTO)
                .toList();
    }

}
