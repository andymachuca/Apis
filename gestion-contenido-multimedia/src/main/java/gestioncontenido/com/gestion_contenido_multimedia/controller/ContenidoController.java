
package gestioncontenido.com.gestion_contenido_multimedia.controller;

import gestioncontenido.com.gestion_contenido_multimedia.dto.CrearContenidoRequest;
import gestioncontenido.com.gestion_contenido_multimedia.models.Contenido;
import gestioncontenido.com.gestion_contenido_multimedia.service.ContenidoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/contenidos")
public class ContenidoController {

    private final ContenidoService contenidoService;

    public ContenidoController(ContenidoService contenidoService) {
        this.contenidoService = contenidoService;
    }

    @PostMapping
    public ResponseEntity<?> crearContenido(@Valid @RequestBody CrearContenidoRequest request) {
        Contenido nuevo = contenidoService.crearContenido(request);
        URI location = URI.create("/api/contenidos/" + nuevo.getId());
        return ResponseEntity.created(location).body(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<Contenido>> getAll() {
        return ResponseEntity.ok(contenidoService.findAll());
    }
}
