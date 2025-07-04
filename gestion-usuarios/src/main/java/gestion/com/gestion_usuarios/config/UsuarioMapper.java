package gestion.com.gestion_usuarios.config;

import org.springframework.stereotype.Component;

import gestion.com.gestion_usuarios.dto.UsuarioDTO;
import gestion.com.gestion_usuarios.models.Usuario;

@Component
public class UsuarioMapper {
    public UsuarioDTO usuarioToDto(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setNombreUsuario(usuario.getNombreUsuario());
        dto.setEmail(usuario.getEmail());
        dto.setRol(usuario.getRol());
        dto.setEstado(usuario.getEstado());
        return dto;
    }
}