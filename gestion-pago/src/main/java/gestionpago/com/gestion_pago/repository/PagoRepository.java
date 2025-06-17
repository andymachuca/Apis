
package gestionpago.com.gestion_pago.repository;

import gestionpago.com.gestion_pago.models.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
}
