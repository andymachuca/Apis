package gestion.com.gestion_usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.com.gestion_usuarios.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}