package com.MacheNotas.MacheNotas_api.mapper;

import com.MacheNotas.MacheNotas_api.model.dto.DocenteRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.DocenteResponseDTO;
import com.MacheNotas.MacheNotas_api.model.entity.Docente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component

public class DocenteMapper {
    private final ModelMapper modelMapper;

    public Docente convertToEntity(DocenteRequestDTO docenteRequestDTO) {
        return modelMapper.map(docenteRequestDTO, Docente.class);
    }

    public DocenteResponseDTO convertToDTO(Docente docente) {
        return modelMapper.map(docente, DocenteResponseDTO.class);
    }

    public List<DocenteResponseDTO> convertToListDTO(List<Docente> docentes) {

        return docentes.stream()
                .map(this::convertToDTO)
                .toList();
    }

}
