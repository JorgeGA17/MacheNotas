package com.MacheNotas.MacheNotas_api.service;

import com.MacheNotas.MacheNotas_api.exception.ResourceNotFoundException;
import com.MacheNotas.MacheNotas_api.mapper.UnidadMapper;
import com.MacheNotas.MacheNotas_api.model.dto.UnidadRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.UnidadResponseDTO;
import com.MacheNotas.MacheNotas_api.model.entity.Unidad;
import com.MacheNotas.MacheNotas_api.repository.UnidadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UnidadService {

    private UnidadRepository unidadRepository;
    private UnidadMapper unidadMapper;

    @Transactional(readOnly = true)
    public List<UnidadResponseDTO> getAllUnidades() {
        List<Unidad> unidades = unidadRepository.findAll();
        return unidadMapper.convertToListDTO(unidades);
    }

    @Transactional(readOnly = true)
    public UnidadResponseDTO getUnidadById(Long id) {
        Unidad unidad = unidadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unidad no encontrada" + id));
        return unidadMapper.convertToDTO(unidad);
    }

    @Transactional
    public UnidadResponseDTO createUnidad(UnidadRequestDTO unidadRequestDTO) {
        Unidad unidad = unidadMapper.convertToEntity(unidadRequestDTO);
        unidadRepository.save(unidad);
        return unidadMapper.convertToDTO(unidad);
    }

    @Transactional
    public UnidadResponseDTO updateUnidad(Long id, UnidadRequestDTO unidadRequestDTO) {
        Unidad unidad = unidadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unidad no encontrada" + id));
        unidad.setNombre(unidadRequestDTO.getNombre());
        unidad.setDuracion(unidadRequestDTO.getDuracion());
        unidad.setCreditaje(unidadRequestDTO.getCreditaje());
        unidad.setCalificacion(unidadRequestDTO.getCalificacion());
        unidad = unidadRepository.save(unidad);
        return unidadMapper.convertToDTO(unidad);
    }

    @Transactional
    public void deleteUnidad(Long id) {
        unidadRepository.deleteById(id);
    }
}