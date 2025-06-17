
package gestionanaliticas.com.gestion_analiticas.repository;

import gestionanaliticas.com.gestion_analiticas.models.Analitica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliticaRepository extends JpaRepository<Analitica, Long> {
}

