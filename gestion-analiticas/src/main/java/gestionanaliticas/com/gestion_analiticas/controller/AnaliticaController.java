
package gestionanaliticas.com.gestion_analiticas.controller;

import gestionanaliticas.com.gestion_analiticas.dto.CrearAnaliticaRequest;
import gestionanaliticas.com.gestion_analiticas.models.Analitica;
import gestionanaliticas.com.gestion_analiticas.service.AnaliticaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/analiticas")
public class AnaliticaController {

    private final AnaliticaService analiticaService;

    public AnaliticaController(AnaliticaService analiticaService) {
        this.analiticaService = analiticaService;
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody CrearAnaliticaRequest request) {
        Analitica nueva = analiticaService.crear(request);
        URI location = URI.create("/api/analiticas/" + nueva.getId());
        return ResponseEntity.created(location).body(nueva);
    }

    @GetMapping
    public ResponseEntity<List<Analitica>> obtener() {
        return ResponseEntity.ok(analiticaService.findAll());
    }
}
