package gestioncontenido.com.gestion_contenido_multimedia.controller;

import gestioncontenido.com.gestion_contenido_multimedia.dto.CrearContenidoRequest;
import gestioncontenido.com.gestion_contenido_multimedia.models.Contenido;
import gestioncontenido.com.gestion_contenido_multimedia.service.ContenidoService;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contenido")
public class ContenidoController {

    private final ContenidoService contenidoService;

    public ContenidoController(ContenidoService contenidoService) {
        this.contenidoService = contenidoService;
    }

    @PostMapping
    public ResponseEntity<Contenido> crearContenido(@Valid @RequestBody CrearContenidoRequest request) {
        return ResponseEntity.ok(contenidoService.crearContenido(request));
    }

    @GetMapping
    public ResponseEntity<List<Contenido>> obtenerTodos() {
        return ResponseEntity.ok(contenidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Contenido>> obtenerPorId(@PathVariable Long id) {
        Contenido contenido = contenidoService.obtenerPorId(id);
        EntityModel<Contenido> resource = EntityModel.of(contenido);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ContenidoController.class).obtenerPorId(id)).withSelfRel());
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ContenidoController.class).obtenerTodos()).withRel("todos"));
        return ResponseEntity.ok(resource);
    }
}
