package com.MacheNotas.MacheNotas_api.service;

import com.MacheNotas.MacheNotas_api.exception.ResourceNotFoundException;
import com.MacheNotas.MacheNotas_api.mapper.DocenteMapper;
import com.MacheNotas.MacheNotas_api.mapper.PeriodoMapper;
import com.MacheNotas.MacheNotas_api.mapper.ProgramaMapper;
import com.MacheNotas.MacheNotas_api.model.dto.PeriodoRequestDTO;
import com.MacheNotas.MacheNotas_api.model.dto.PeriodoResponseDTO;
import com.MacheNotas.MacheNotas_api.model.entity.Periodo;
import com.MacheNotas.MacheNotas_api.repository.DocenteRepository;
import com.MacheNotas.MacheNotas_api.repository.PeriodoRepository;
import com.MacheNotas.MacheNotas_api.repository.ProgramaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PeriodoService {

    private PeriodoRepository periodoRepository;
    private PeriodoMapper periodoMapper;


    @Transactional(readOnly = true)
    public List<PeriodoResponseDTO> getAllPeriodos() {
        List<Periodo> periodos = periodoRepository.findAll();
        return periodoMapper.convertToListDTO(periodos);
    }

    @Transactional(readOnly = true)
    public PeriodoResponseDTO getPeriodoById(Long id) {
        Periodo periodo = periodoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Periodo no encontrado" + id));
        return periodoMapper.convertToDTO(periodo);
    }

    @Transactional
    public PeriodoResponseDTO createPeriodo(PeriodoRequestDTO periodoRequestDTO) {
        Periodo periodo = periodoMapper.convertToEntity(periodoRequestDTO);
        periodoRepository.save(periodo);
        return periodoMapper.convertToDTO(periodo);
    }

    @Transactional
    public PeriodoResponseDTO updatePeriodo(Long id, PeriodoRequestDTO periodoRequestDTO) {
        Periodo periodo = periodoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Periodo no encontrado" + id));

        periodo.setNombre(periodoRequestDTO.getNombre());
        periodo.setInicio(periodoRequestDTO.getInicio());
        periodo.setFin(periodoRequestDTO.getFin());
        periodo = periodoRepository.save(periodo);
        return periodoMapper.convertToDTO(periodo);
    }

    @Transactional
    public void deletePeriodo(Long id) {
        periodoRepository.deleteById(id);
    }
}