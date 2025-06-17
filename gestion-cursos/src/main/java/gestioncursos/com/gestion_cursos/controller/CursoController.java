
package gestioncursos.com.gestion_cursos.controller;

import gestioncursos.com.gestion_cursos.dto.CrearCursoRequest;
import gestioncursos.com.gestion_cursos.models.Curso;
import gestioncursos.com.gestion_cursos.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<?> crearCurso(@Valid @RequestBody CrearCursoRequest request) {
        Curso nuevoCurso = cursoService.crearCurso(request);
        URI location = URI.create("/api/cursos/" + nuevoCurso.getIdCurso());
        return ResponseEntity.created(location).body(nuevoCurso);
    }

    @GetMapping
    public ResponseEntity<List<Curso>> obtenerCursos() {
        return ResponseEntity.ok(cursoService.findAll());
    }
}
