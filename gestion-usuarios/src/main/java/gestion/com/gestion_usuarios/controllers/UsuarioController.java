package gestion.com.gestion_usuarios.controllers;

import gestion.com.gestion_usuarios.dto.CrearUsuarioRequest;
import gestion.com.gestion_usuarios.dto.UsuarioDTO;
import gestion.com.gestion_usuarios.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> obtenerTodos() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<UsuarioDTO>> obtenerPorId(@PathVariable Integer id) {
        UsuarioDTO dto = usuarioService.buscarUsuarioPorId(id);
        EntityModel<UsuarioDTO> resource = EntityModel.of(dto);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioController.class).obtenerPorId(id)).withSelfRel());
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioController.class).obtenerTodos()).withRel("todos"));
        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> crear(@Valid @RequestBody CrearUsuarioRequest request) {
        return ResponseEntity.ok(new UsuarioDTO(usuarioService.crearUsuario(request).getIdUsuario(),
                request.getNombreUsuario(), request.getEmail(), request.getRol(), request.getEstado()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizar(@PathVariable Integer id, @RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.actualizarUsuario(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
