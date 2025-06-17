
package gestionnotificaciones.com.gestion_notificaciones.repository;

import gestionnotificaciones.com.gestion_notificaciones.models.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
}
