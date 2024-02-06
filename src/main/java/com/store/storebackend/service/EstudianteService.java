package com.store.storebackend.service;

import com.store.storebackend.dto.EstudianteDto;

import java.util.List;

public interface EstudianteService {
    EstudianteDto createEstudiante(EstudianteDto estudianteDto);
    EstudianteDto getEstudianteByDocumento(Long numero_de_documento);
    List<EstudianteDto> getAllEstudiantes();
    EstudianteDto updateEstudiante(Long numero_de_documento, EstudianteDto updatedEstudiante);
    void deleteEstudiante(Long numero_de_documento);

    EstudianteDto newcreate(EstudianteDto estudianteDto);
}
