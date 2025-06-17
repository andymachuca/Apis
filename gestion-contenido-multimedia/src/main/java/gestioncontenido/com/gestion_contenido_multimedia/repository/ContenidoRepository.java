
package gestioncontenido.com.gestion_contenido_multimedia.repository;
import gestioncontenido.com.gestion_contenido_multimedia.models.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Long> {
}
