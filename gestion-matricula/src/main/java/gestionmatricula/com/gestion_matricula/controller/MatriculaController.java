
package gestionmatricula.com.gestion_matricula.controller;

import gestionmatricula.com.gestion_matricula.dto.CrearMatriculaRequest;
import gestionmatricula.com.gestion_matricula.models.Matricula;
import gestionmatricula.com.gestion_matricula.service.MatriculaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @PostMapping
    public ResponseEntity<?> crearMatricula(@Valid @RequestBody CrearMatriculaRequest request) {
        Matricula nueva = matriculaService.crearMatricula(request);
        URI location = URI.create("/api/matriculas/" + nueva.getId());
        return ResponseEntity.created(location).body(nueva);
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> getAll() {
        return ResponseEntity.ok(matriculaService.findAll());
    }
}
