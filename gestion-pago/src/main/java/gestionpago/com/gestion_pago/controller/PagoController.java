package gestionpago.com.gestion_pago.controller;

import gestionpago.com.gestion_pago.dto.CrearPagoRequest;
import gestionpago.com.gestion_pago.models.Pago;
import gestionpago.com.gestion_pago.service.PagoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@Tag(name = "Pagos", description = "Operaciones relacionadas con pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @Operation(summary = "Crear un nuevo pago")
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody CrearPagoRequest request) {
        Pago nuevo = pagoService.crear(request);
        URI location = URI.create("/api/pagos/" + nuevo.getId());
        return ResponseEntity.created(location).body(nuevo);
    }

    @Operation(summary = "Obtener un pago por ID")
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Pago>> obtenerPorId(@PathVariable Long id) {
        Pago pago = pagoService.obtenerPorId(id);
        EntityModel<Pago> resource = EntityModel.of(pago);

        resource.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(PagoController.class).obtenerPorId(id)
        ).withSelfRel());

        resource.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(PagoController.class).obtener()
        ).withRel("todos"));

        return ResponseEntity.ok(resource);
    }

    @Operation(summary = "Obtener todos los pagos")
    @GetMapping
    public ResponseEntity<List<Pago>> obtener() {
        return ResponseEntity.ok(pagoService.findAll());
    }
}
