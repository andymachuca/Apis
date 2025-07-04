package gestionevaluaciones.com.gestion_evaluaciones.controller;

import gestionevaluaciones.com.gestion_evaluaciones.dto.CrearEvaluacionRequest;
import gestionevaluaciones.com.gestion_evaluaciones.models.Evaluacion;
import gestionevaluaciones.com.gestion_evaluaciones.service.EvaluacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    private final EvaluacionService evaluacionService;

    public EvaluacionController(EvaluacionService evaluacionService) {
        this.evaluacionService = evaluacionService;
    }

    @Operation(summary = "Crear una nueva evaluación")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Evaluación creada correctamente",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Evaluacion.class)))
    })
    @PostMapping
    public ResponseEntity<Evaluacion> crearEvaluacion(@Valid @RequestBody CrearEvaluacionRequest request) {
        Evaluacion nueva = evaluacionService.crearEvaluacion(request);
        return ResponseEntity.ok(nueva);
    }

    @Operation(summary = "Obtener todas las evaluaciones")
    @GetMapping
    public ResponseEntity<List<Evaluacion>> obtenerTodas() {
        return ResponseEntity.ok(evaluacionService.obtenerTodos());
    }

    @Operation(summary = "Obtener evaluación por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Evaluación encontrada",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Evaluacion.class))),
        @ApiResponse(responseCode = "404", description = "Evaluación no encontrada",
            content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Evaluacion>> obtenerPorId(@PathVariable Long id) {
        Evaluacion evaluacion = evaluacionService.obtenerPorId(id);
        EntityModel<Evaluacion> resource = EntityModel.of(evaluacion);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EvaluacionController.class).obtenerPorId(id)).withSelfRel());
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EvaluacionController.class).obtenerTodas()).withRel("todas"));
        return ResponseEntity.ok(resource);
    }
}
