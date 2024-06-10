package com.MacheNotas.MacheNotas_api.service;

import com.MacheNotas.MacheNotas_api.exception.ResourceNotFoundException;
import com.MacheNotas.MacheNotas_api.mapper.DocenteMapper;
import com.MacheNotas.MacheNotas_api.model.dto.DocenteRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.DocenteResponseDTO;
import com.MacheNotas.MacheNotas_api.model.entity.Docente;
import com.MacheNotas.MacheNotas_api.repository.DocenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor

public class DocenteService {

    private DocenteRepository docenteRepository;
    private DocenteMapper docenteMapper;

    @Transactional(readOnly = true)
    public List<DocenteResponseDTO> getAllDocentes() {
        List<Docente> docentes = docenteRepository.findAll();
        return docenteMapper.convertToListDTO(docentes);
    }

    @Transactional(readOnly = true)
    public DocenteResponseDTO getDocenteById(Long id) {
        Docente docente = docenteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Docente no encontrado"+ id));
        return docenteMapper.convertToDTO(docente);
    }

    @Transactional
    public DocenteResponseDTO createDocente(DocenteRequestDTO docenteRequestDTO) {
        Docente docente = docenteMapper.convertToEntity(docenteRequestDTO);
        docenteRepository.save(docente);
        return docenteMapper.convertToDTO(docente);
    }

    @Transactional
    public DocenteResponseDTO updateDocente(Long id, DocenteRequestDTO docenteRequestDTO) {
        Docente docente= docenteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Docente no encontrado"+id));
        docente.setNombre(docenteRequestDTO.getNombre());
        docente.setEmail(docenteRequestDTO.getEmail());
        docente.setPassword(docenteRequestDTO.getPassword());
        docente=docenteRepository.save(docente);
        return docenteMapper.convertToDTO(docente);
    }

    @Transactional
    public void deleteDocente(Long id) {
        docenteRepository.deleteById(id);
    }

}
