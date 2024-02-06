package com.store.storebackend.controller;

import com.store.storebackend.dto.EstudianteDto;
import com.store.storebackend.service.EstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    private EstudianteService estudianteService;
    @PostMapping
    public ResponseEntity<EstudianteDto> createEstudiante(@RequestBody EstudianteDto estudianteDto){
        EstudianteDto savedEstudiante = estudianteService.createEstudiante(estudianteDto);
        return new ResponseEntity<>(savedEstudiante, HttpStatus.CREATED);
    }

    @GetMapping("{NumeroDeDocumento}")
    public ResponseEntity<EstudianteDto> getEstudianteBydocumento(@PathVariable("NumeroDeDocumento") Long numero_de_documento){
        EstudianteDto estudianteDto = estudianteService.getEstudianteByDocumento(numero_de_documento);
        return ResponseEntity.ok(estudianteDto);
    }
    @GetMapping
    public ResponseEntity<List<EstudianteDto>> getAllEstudiantes(){
        List<EstudianteDto> estudiantes = estudianteService.getAllEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }
    @PutMapping("{numero_de_documento}")
    public ResponseEntity<EstudianteDto> updateEstudiante(@PathVariable("numero_de_documento") Long numero_de_documento,
                                                          @RequestBody EstudianteDto updatedEstudiante){
        EstudianteDto estudianteDto = estudianteService.updateEstudiante(numero_de_documento, updatedEstudiante);
        return ResponseEntity.ok(estudianteDto);
    }
    @DeleteMapping("{numero_de_documento}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("numero_de_documento") Long numero_de_documento){
        estudianteService.deleteEstudiante(numero_de_documento);
        return ResponseEntity.ok("Empleado eliminado existosamente!.");
    }
}
