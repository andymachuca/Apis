
package gestionmatricula.com.gestion_matricula.service;

import gestionmatricula.com.gestion_matricula.dto.CrearMatriculaRequest;
import gestionmatricula.com.gestion_matricula.models.Matricula;
import gestionmatricula.com.gestion_matricula.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public Matricula crearMatricula(CrearMatriculaRequest request) {
        Matricula matricula = new Matricula();
        matricula.setIdCliente(request.getIdCliente());
        matricula.setIdCurso(request.getIdCurso());
        matricula.setEstado(request.getEstado());
        return matriculaRepository.save(matricula);
    }

    public List<Matricula> findAll() {
        return matriculaRepository.findAll();
    }
     public Matricula obtenerPorId(Long id) {
        return matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula no encontrada con ID: " + id));
    }
}
