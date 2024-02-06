package com.store.storebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String correo_institucional;
    private String tipo_de_documento;

    @Column(name = "numero_de_documento")
    private Long numeroDeDocumento;
    private String nombre;
    private String apellido;
    private String facultad;
    private String programa;
    private String sede;
    private String vinculo;

    public Estudiante(Long id, String correoInstitucional, String nombre, String apellido, String tipoDeDocumento, Long numeroDeDocumento, String sede, String facultad, String programa, String vinculo) {
        this.id = id;
        this.correo_institucional = correoInstitucional;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_de_documento = tipoDeDocumento;
        this.numeroDeDocumento = numeroDeDocumento;
        this.sede = sede;
        this.facultad = facultad;
        this.programa = programa;
        this.vinculo = vinculo;
    }
}