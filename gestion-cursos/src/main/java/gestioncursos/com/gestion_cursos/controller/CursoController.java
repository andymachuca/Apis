package gestioncursos.com.gestion_cursos.controller;

import gestioncursos.com.gestion_cursos.models.Curso;
import gestioncursos.com.gestion_cursos.services.CursoService;
import gestioncursos.com.gestion_cursos.dto.CrearCursoRequest;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<Curso> crearCurso(@Valid @RequestBody CrearCursoRequest request) {
        return ResponseEntity.ok(cursoService.crearCurso(request));
    }

    @GetMapping
    public ResponseEntity<List<Curso>> obtenerTodos() {
        return ResponseEntity.ok(cursoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Curso>> obtenerPorId(@PathVariable Long id) {
        Curso curso = cursoService.obtenerPorId(id);
        EntityModel<Curso> resource = EntityModel.of(curso);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CursoController.class).obtenerPorId(id)).withSelfRel());
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CursoController.class).obtenerTodos()).withRel("todos"));
        return ResponseEntity.ok(resource);
    }
}
