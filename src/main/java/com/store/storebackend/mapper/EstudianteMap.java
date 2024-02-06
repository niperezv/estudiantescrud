package com.store.storebackend.mapper;

import com.store.storebackend.dto.EstudianteDto;
import com.store.storebackend.entity.Estudiante;

public class EstudianteMap {

    public static EstudianteDto mapToEstudianteDto(Estudiante estudiante) {
        return new EstudianteDto(
                estudiante.getId(),
                estudiante.getCorreo_institucional(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                estudiante.getTipo_de_documento(),
                estudiante.getNumeroDeDocumento(),
                estudiante.getSede(),
                estudiante.getFacultad(),
                estudiante.getPrograma(),
                estudiante.getVinculo()
        );
    }
    public static Estudiante mapToEstudiante(EstudianteDto estudianteDto){
        return new Estudiante(
                estudianteDto.getId(),
                estudianteDto.getCorreo_institucional(),
                estudianteDto.getNombre(),
                estudianteDto.getApellido(),
                estudianteDto.getTipo_de_documento(),
                estudianteDto.getNumero_de_documento(),
                estudianteDto.getSede(),
                estudianteDto.getFacultad(),
                estudianteDto.getPrograma(),
                estudianteDto.getVinculo()
        );
    }
}
