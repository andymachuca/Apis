package gestionanaliticas.com.gestion_analiticas.controller;

import gestionanaliticas.com.gestion_analiticas.dto.CrearAnaliticaRequest;
import gestionanaliticas.com.gestion_analiticas.models.Analitica;
import gestionanaliticas.com.gestion_analiticas.service.AnaliticaService;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analiticas")
public class AnaliticaController {

    private final AnaliticaService analiticaService;

    public AnaliticaController(AnaliticaService analiticaService) {
        this.analiticaService = analiticaService;
    }

    @PostMapping
    public ResponseEntity<Analitica> crear(@Valid @RequestBody CrearAnaliticaRequest request) {
        return ResponseEntity.ok(analiticaService.crear(request));
    }

    @GetMapping
    public ResponseEntity<List<Analitica>> obtenerTodos() {
        return ResponseEntity.ok(analiticaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Analitica>> obtenerPorId(@PathVariable Long id) {
        Analitica analitica = analiticaService.obtenerPorId(id);
        EntityModel<Analitica> resource = EntityModel.of(analitica);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AnaliticaController.class).obtenerPorId(id)).withSelfRel());
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AnaliticaController.class).obtenerTodos()).withRel("todos"));
        return ResponseEntity.ok(resource);
    }
}
