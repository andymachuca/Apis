package gestionnotificaciones.com.gestion_notificaciones.controller;

import gestionnotificaciones.com.gestion_notificaciones.dto.CrearNotificacionRequest;
import gestionnotificaciones.com.gestion_notificaciones.models.Notificacion;
import gestionnotificaciones.com.gestion_notificaciones.service.NotificacionService;
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
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    private final NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @Operation(summary = "Obtener una notificación por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Notificación encontrada",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Notificacion.class))),
        @ApiResponse(responseCode = "404", description = "Notificación no encontrada",
                content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Notificacion>> obtenerPorId(@PathVariable Long id) {
        Notificacion obj = notificacionService.obtenerPorId(id);
        EntityModel<Notificacion> resource = EntityModel.of(obj);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(NotificacionController.class).obtenerPorId(id)).withSelfRel());
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(NotificacionController.class).obtenerTodos()).withRel("todos"));
        return ResponseEntity.ok(resource);
    }

    @Operation(summary = "Listar todas las notificaciones")
    @GetMapping
    public ResponseEntity<List<Notificacion>> obtenerTodos() {
        return ResponseEntity.ok(notificacionService.obtenerTodos());
    }

    @Operation(summary = "Crear una nueva notificación")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Notificación creada exitosamente",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Notificacion.class)))
    })
    @PostMapping
    public ResponseEntity<Notificacion> crear(@Valid @RequestBody CrearNotificacionRequest request) {
        Notificacion creada = notificacionService.crear(request);
        return ResponseEntity.ok(creada);
    }
}
