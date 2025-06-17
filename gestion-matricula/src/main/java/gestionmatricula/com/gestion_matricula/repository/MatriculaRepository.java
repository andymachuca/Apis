
package gestionmatricula.com.gestion_matricula.repository;

import gestionmatricula.com.gestion_matricula.models.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
