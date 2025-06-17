
package gestioncontenido.com.gestion_contenido_multimedia.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CrearContenidoRequest {

    @NotNull
    private Integer idCurso;

    @NotNull
    @Size(min = 3, max = 100)
    private String titulo;

    @NotNull
    @Size(min = 5, max = 250)
    private String descripcion;

    @NotNull
    private String url;

    @NotNull
    private String tipo;

    private boolean activo;
}
