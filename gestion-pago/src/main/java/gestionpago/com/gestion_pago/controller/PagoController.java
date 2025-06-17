
package gestionpago.com.gestion_pago.controller;

import gestionpago.com.gestion_pago.dto.CrearPagoRequest;
import gestionpago.com.gestion_pago.models.Pago;
import gestionpago.com.gestion_pago.service.PagoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody CrearPagoRequest request) {
        Pago nuevo = pagoService.crear(request);
        URI location = URI.create("/api/pagos/" + nuevo.getId());
        return ResponseEntity.created(location).body(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<Pago>> obtener() {
        return ResponseEntity.ok(pagoService.findAll());
    }
}
