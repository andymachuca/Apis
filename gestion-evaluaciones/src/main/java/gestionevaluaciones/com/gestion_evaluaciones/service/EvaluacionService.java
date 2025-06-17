
package gestionevaluaciones.com.gestion_evaluaciones.service;

import gestionevaluaciones.com.gestion_evaluaciones.dto.CrearEvaluacionRequest;
import gestionevaluaciones.com.gestion_evaluaciones.models.Evaluacion;
import gestionevaluaciones.com.gestion_evaluaciones.repository.EvaluacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluacionService {

    private final EvaluacionRepository evaluacionRepository;

    public EvaluacionService(EvaluacionRepository evaluacionRepository) {
        this.evaluacionRepository = evaluacionRepository;
    }

    public Evaluacion crearEvaluacion(CrearEvaluacionRequest request) {
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setIdCurso(request.getIdCurso());
        evaluacion.setTitulo(request.getTitulo());
        evaluacion.setDescripcion(request.getDescripcion());
        evaluacion.setTipo(request.getTipo());
        evaluacion.setFechaEntrega(request.getFechaEntrega());
        evaluacion.setPuntajeMaximo(request.getPuntajeMaximo());
        evaluacion.setActiva(request.isActiva());
        return evaluacionRepository.save(evaluacion);
    }

    public List<Evaluacion> findAll() {
        return evaluacionRepository.findAll();
    }
}
