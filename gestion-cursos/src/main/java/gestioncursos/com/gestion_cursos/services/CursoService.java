
package gestioncursos.com.gestion_cursos.services;

import gestioncursos.com.gestion_cursos.dto.CrearCursoRequest;
import gestioncursos.com.gestion_cursos.models.Curso;
import gestioncursos.com.gestion_cursos.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso crearCurso(CrearCursoRequest request) {
        if (cursoRepository.existsByNombre(request.getNombre())) {
            throw new IllegalArgumentException("Ya existe un curso con ese nombre");
        }

        Curso curso = new Curso();
        curso.setNombre(request.getNombre());
        curso.setDescripcion(request.getDescripcion());
        curso.setDuracion(request.getDuracion());
        curso.setEstado(request.isEstado());

        return cursoRepository.save(curso);
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }
    public Curso obtenerPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
    }
}
