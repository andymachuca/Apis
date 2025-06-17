
package gestioncontenido.com.gestion_contenido_multimedia.service;

import gestioncontenido.com.gestion_contenido_multimedia.dto.CrearContenidoRequest;
import gestioncontenido.com.gestion_contenido_multimedia.models.Contenido;
import gestioncontenido.com.gestion_contenido_multimedia.repository.ContenidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenidoService {

    private final ContenidoRepository contenidoRepository;

    public ContenidoService(ContenidoRepository contenidoRepository) {
        this.contenidoRepository = contenidoRepository;
    }

    public Contenido crearContenido(CrearContenidoRequest request) {
        Contenido contenido = new Contenido();
        contenido.setIdCurso(request.getIdCurso());
        contenido.setTitulo(request.getTitulo());
        contenido.setDescripcion(request.getDescripcion());
        contenido.setUrl(request.getUrl());
        contenido.setTipo(request.getTipo());
        contenido.setActivo(request.isActivo());
        return contenidoRepository.save(contenido);
    }

    public List<Contenido> findAll() {
        return contenidoRepository.findAll();
    }
}
