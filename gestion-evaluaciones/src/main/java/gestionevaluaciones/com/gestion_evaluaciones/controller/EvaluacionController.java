
package gestionevaluaciones.com.gestion_evaluaciones.controller;

import gestionevaluaciones.com.gestion_evaluaciones.dto.CrearEvaluacionRequest;
import gestionevaluaciones.com.gestion_evaluaciones.models.Evaluacion;
import gestionevaluaciones.com.gestion_evaluaciones.service.EvaluacionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    private final EvaluacionService evaluacionService;

    public EvaluacionController(EvaluacionService evaluacionService) {
        this.evaluacionService = evaluacionService;
    }

    @PostMapping
    public ResponseEntity<?> crearEvaluacion(@Valid @RequestBody CrearEvaluacionRequest request) {
        Evaluacion nueva = evaluacionService.crearEvaluacion(request);
        URI location = URI.create("/api/evaluaciones/" + nueva.getId());
        return ResponseEntity.created(location).body(nueva);
    }

    @GetMapping
    public ResponseEntity<List<Evaluacion>> obtenerEvaluaciones() {
        return ResponseEntity.ok(evaluacionService.findAll());
    }
}
