package com.MacheNotas.MacheNotas_api.mapper;

import com.MacheNotas.MacheNotas_api.model.dto.ProgramaRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.ProgramaResponseDTO;
import com.MacheNotas.MacheNotas_api.model.dto.SecretarioRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.SecretarioResponseDTO;
import com.MacheNotas.MacheNotas_api.model.entity.Secretario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@AllArgsConstructor
@Component

public class SecretarioMapper {

    private final ModelMapper modelMapper;

    public Secretario convertToEntity(SecretarioRequestDTO secretarioRequestDTO) {
        return modelMapper.map(secretarioRequestDTO, Secretario.class);
    }

    public SecretarioResponseDTO convertToDTO(Secretario secretario) {
        return modelMapper.map(secretario, SecretarioResponseDTO.class);
    }

    public List<SecretarioResponseDTO> convertToListDTO(List<Secretario> secretarios) {

        return secretarios.stream()
                .map(this::convertToDTO)
                .toList();
    }
}
