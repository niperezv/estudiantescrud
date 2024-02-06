package com.store.storebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EstudianteDto {
    private Long id;
    private String correo_institucional;
    private String tipo_de_documento;
    private Long numero_de_documento;
    private String nombre;
    private String apellido;
    private String facultad;
    private String programa;
    private String sede;
    private String vinculo;

    public EstudianteDto(Long id, String correoInstitucional, String nombre, String apellido, String tipoDeDocumento, Long numeroDeDocumento, String sede, String facultad, String programa, String vinculo) {
        this.id = id;
        this.correo_institucional = correoInstitucional;
        this.tipo_de_documento = tipoDeDocumento;
        this.numero_de_documento = numeroDeDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.facultad = facultad;
        this.programa = programa;
        this.sede = sede;
        this.vinculo = vinculo;
    }
}
