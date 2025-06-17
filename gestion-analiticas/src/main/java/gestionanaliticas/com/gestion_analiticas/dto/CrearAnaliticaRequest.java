
package gestionanaliticas.com.gestion_analiticas.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CrearAnaliticaRequest {

    @NotNull
    private Integer idUsuario;

    private Integer idCurso;

    @NotNull
    private String tipo;

    private String descripcion;
}
