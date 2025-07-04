package gestionnotificaciones.com.gestion_notificaciones;

import gestionnotificaciones.com.gestion_notificaciones.models.Notificacion;
import gestionnotificaciones.com.gestion_notificaciones.service.NotificacionService;
import gestionnotificaciones.com.gestion_notificaciones.controller.NotificacionController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class NotificacionControllerTest {

    @Mock
    private NotificacionService notificacionService;

    @InjectMocks
    private NotificacionController notificacionController;

    @Test
    void testObtenerPorId_devuelveNotificacionConLinks() {
        // Arrange
        Notificacion notificacion = new Notificacion();
        notificacion.setId(1L);
        notificacion.setTitulo("Mensaje de prueba");

        when(notificacionService.obtenerPorId(1L)).thenReturn(notificacion);

        // Act
        ResponseEntity<EntityModel<Notificacion>> response = notificacionController.obtenerPorId(1L);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1L, response.getBody().getContent().getId());
        assertEquals("Mensaje de prueba", response.getBody().getContent().getTitulo());
    }
}
