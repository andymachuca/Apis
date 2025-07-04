package gestionmatricula.com.gestion_matricula.controller;

import gestionmatricula.com.gestion_matricula.dto.CrearMatriculaRequest;
import gestionmatricula.com.gestion_matricula.models.Matricula;
import gestionmatricula.com.gestion_matricula.service.MatriculaService;
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
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @Operation(summary = "Crear una nueva matrícula")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Matrícula creada correctamente",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Matricula.class)))
    })
    @PostMapping
    public ResponseEntity<Matricula> crearMatricula(@Valid @RequestBody CrearMatriculaRequest request) {
        Matricula nueva = matriculaService.crearMatricula(request);
        return ResponseEntity.ok(nueva);
    }

    @Operation(summary = "Obtener todas las matrículas")
    @GetMapping
    public ResponseEntity<List<Matricula>> obtenerTodas() {
        return ResponseEntity.ok(matriculaService.findAll());
    }

    @Operation(summary = "Obtener matrícula por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Matrícula encontrada",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Matricula.class))),
        @ApiResponse(responseCode = "404", description = "Matrícula no encontrada",
            content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Matricula>> obtenerPorId(@PathVariable Long id) {
        Matricula matricula = matriculaService.obtenerPorId(id);
        EntityModel<Matricula> resource = EntityModel.of(matricula);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MatriculaController.class).obtenerPorId(id)).withSelfRel());
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MatriculaController.class).obtenerTodas()).withRel("todas"));
        return ResponseEntity.ok(resource);
    }
}
