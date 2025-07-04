package gestion.com.gestion_usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.com.gestion_usuarios.models.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

}