package com.store.storebackend.repository;

import com.store.storebackend.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EstudianteRepo extends JpaRepository<Estudiante, Long> {
    Optional<Estudiante> findByNumeroDeDocumento(Long numeroDeDocumento);
}
