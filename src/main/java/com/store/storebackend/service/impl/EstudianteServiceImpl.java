package com.store.storebackend.service.impl;

import com.store.storebackend.dto.EstudianteDto;
import com.store.storebackend.entity.Estudiante;
import com.store.storebackend.exception.ResourcerNotFoundException;
import com.store.storebackend.mapper.EstudianteMap;
import com.store.storebackend.repository.EstudianteRepo;
import com.store.storebackend.service.EstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {
    private EstudianteRepo estudianteRepo;

    @Override
    public EstudianteDto createEstudiante(EstudianteDto estudianteDto) {
        Estudiante estudiante = EstudianteMap.mapToEstudiante(estudianteDto);
        Estudiante savedEstudiante = estudianteRepo.save(estudiante);
        return EstudianteMap.mapToEstudianteDto(savedEstudiante);
    }

    @Override
    public EstudianteDto getEstudianteByDocumento(Long numero_de_documento) {
        Estudiante estudiante = estudianteRepo.findByNumeroDeDocumento(numero_de_documento)
                .orElseThrow(() -> new ResolutionException("Estudiante no existe con esa cedula :" + numero_de_documento));
        return EstudianteMap.mapToEstudianteDto(estudiante);
    }

    @Override
    public List<EstudianteDto> getAllEstudiantes() {
        List<Estudiante> estudiantes = estudianteRepo.findAll();
        return estudiantes.stream().map((estudiante) -> EstudianteMap.mapToEstudianteDto(estudiante))
                .collect(Collectors.toList());
    }

    @Override
    public EstudianteDto updateEstudiante(Long numero_de_documento, EstudianteDto updatedEstudiante) {
        Estudiante estudiante = estudianteRepo.findByNumeroDeDocumento(numero_de_documento).orElseThrow(
                () -> new ResourcerNotFoundException("No existe un estudiante con ese numero de documento:" + numero_de_documento)
        );

        estudiante.setNombre(updatedEstudiante.getNombre());
        estudiante.setApellido(updatedEstudiante.getApellido());
        estudiante.setTipo_de_documento(updatedEstudiante.getTipo_de_documento());
        estudiante.setNumeroDeDocumento(updatedEstudiante.getNumero_de_documento());
        estudiante.setCorreo_institucional(updatedEstudiante.getCorreo_institucional());
        estudiante.setSede(updatedEstudiante.getSede());
        estudiante.setFacultad(updatedEstudiante.getFacultad());
        estudiante.setPrograma(updatedEstudiante.getPrograma());
        estudiante.setVinculo(updatedEstudiante.getVinculo());

        Estudiante updateEstudianteObj = estudianteRepo.save(estudiante);

        return EstudianteMap.mapToEstudianteDto(updateEstudianteObj);
    }

    @Override
    public void deleteEstudiante(Long numero_de_documento) {

        Estudiante estudiante = estudianteRepo.findByNumeroDeDocumento(numero_de_documento).orElseThrow(
                () -> new ResourcerNotFoundException("No existe un estudiante con ese numero de documento:" + numero_de_documento)
        );

        estudianteRepo.delete(estudiante);
    }

    @Override
    public EstudianteDto newcreate(EstudianteDto estudianteDto) {
        return null;
    }
}
