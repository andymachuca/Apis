
package gestionnotificaciones.com.gestion_notificaciones.service;

import gestionnotificaciones.com.gestion_notificaciones.dto.CrearNotificacionRequest;
import gestionnotificaciones.com.gestion_notificaciones.models.Notificacion;
import gestionnotificaciones.com.gestion_notificaciones.repository.NotificacionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;

    public NotificacionService(NotificacionRepository notificacionRepository) {
        this.notificacionRepository = notificacionRepository;
    }

    public Notificacion crear(CrearNotificacionRequest request) {
        Notificacion n = new Notificacion();
        n.setIdUsuario(request.getIdUsuario());
        n.setTitulo(request.getTitulo());
        n.setMensaje(request.getMensaje());
        n.setTipo(request.getTipo());
        n.setFechaCreacion(LocalDateTime.now());
        n.setLeido(request.isLeido());
        return notificacionRepository.save(n);
    }

    public List<Notificacion> findAll() {
        return notificacionRepository.findAll();
    }
}
