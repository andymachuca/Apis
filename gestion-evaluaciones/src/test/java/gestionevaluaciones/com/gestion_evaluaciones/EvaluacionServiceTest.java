
package gestionevaluaciones.com.gestion_evaluaciones;

import gestionevaluaciones.com.gestion_evaluaciones.models.Evaluacion;
import gestionevaluaciones.com.gestion_evaluaciones.repository.EvaluacionRepository;
import gestionevaluaciones.com.gestion_evaluaciones.service.EvaluacionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EvaluacionServiceTest {

    private EvaluacionRepository evaluacionRepository;
    private EvaluacionService evaluacionService;

    @BeforeEach
    void setUp() {
        evaluacionRepository = mock(EvaluacionRepository.class);
        evaluacionService = new EvaluacionService(evaluacionRepository);
    }

    @Test
    void testObtenerPorId_devuelveEvaluacion() {
        // Arrange
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setId(1L);
        evaluacion.setTitulo("Prueba JUnit");

        when(evaluacionRepository.findById(1L)).thenReturn(Optional.of(evaluacion));

        // Act
        Evaluacion resultado = evaluacionService.obtenerPorId(1L);

        // Assert
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Prueba JUnit", resultado.getTitulo());
    }
}
