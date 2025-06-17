
package gestionnotificaciones.com.gestion_notificaciones.controller;

import gestionnotificaciones.com.gestion_notificaciones.dto.CrearNotificacionRequest;
import gestionnotificaciones.com.gestion_notificaciones.models.Notificacion;
import gestionnotificaciones.com.gestion_notificaciones.service.NotificacionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    private final NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody CrearNotificacionRequest request) {
        Notificacion nueva = notificacionService.crear(request);
        URI location = URI.create("/api/notificaciones/" + nueva.getId());
        return ResponseEntity.created(location).body(nueva);
    }

    @GetMapping
    public ResponseEntity<List<Notificacion>> obtener() {
        return ResponseEntity.ok(notificacionService.findAll());
    }
}
