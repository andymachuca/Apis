
package gestionanaliticas.com.gestion_analiticas.service;

import gestionanaliticas.com.gestion_analiticas.dto.CrearAnaliticaRequest;
import gestionanaliticas.com.gestion_analiticas.models.Analitica;
import gestionanaliticas.com.gestion_analiticas.repository.AnaliticaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnaliticaService {

    private final AnaliticaRepository analiticaRepository;

    public AnaliticaService(AnaliticaRepository analiticaRepository) {
        this.analiticaRepository = analiticaRepository;
    }

    public Analitica crear(CrearAnaliticaRequest request) {
        Analitica a = new Analitica();
        a.setIdUsuario(request.getIdUsuario());
        a.setIdCurso(request.getIdCurso());
        a.setTipo(request.getTipo());
        a.setDescripcion(request.getDescripcion());
        a.setFechaEvento(LocalDateTime.now());
        return analiticaRepository.save(a);
    }

    public List<Analitica> findAll() {
        return analiticaRepository.findAll();
    }
}
