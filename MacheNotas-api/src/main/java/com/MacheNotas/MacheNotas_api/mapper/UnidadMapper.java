package com.MacheNotas.MacheNotas_api.mapper;

import com.MacheNotas.MacheNotas_api.model.dto.SecretarioRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.SecretarioResponseDTO;
import com.MacheNotas.MacheNotas_api.model.dto.UnidadRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.UnidadResponseDTO;
import com.MacheNotas.MacheNotas_api.model.entity.Unidad;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component

public class UnidadMapper {

    private final ModelMapper modelMapper;

    public Unidad convertToEntity(UnidadRequestDTO unidadRequestDTO) {
        return modelMapper.map(unidadRequestDTO, Unidad.class);
    }

    public UnidadResponseDTO convertToDTO(Unidad unidad) {
        return modelMapper.map(unidad, UnidadResponseDTO.class);
    }

    public List<UnidadResponseDTO> convertToListDTO(List<Unidad> unidades) {

        return unidades.stream()
                .map(this::convertToDTO)
                .toList();
    }
}