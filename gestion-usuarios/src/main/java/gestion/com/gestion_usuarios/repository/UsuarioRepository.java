package gestion.com.gestion_usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.com.gestion_usuarios.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
