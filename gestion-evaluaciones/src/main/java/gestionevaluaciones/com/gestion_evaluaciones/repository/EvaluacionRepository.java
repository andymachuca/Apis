
package gestionevaluaciones.com.gestion_evaluaciones.repository;

import gestionevaluaciones.com.gestion_evaluaciones.models.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
}
