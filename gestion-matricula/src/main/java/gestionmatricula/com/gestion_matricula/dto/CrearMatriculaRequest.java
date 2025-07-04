
package gestionmatricula.com.gestion_matricula.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CrearMatriculaRequest {

    @NotNull(message = "El ID del estudiante no puede ser nulo")
    private Integer idCliente;

    @NotNull(message = "El ID del curso no puede ser nulo")
    private Integer idCurso;

    @NotNull(message = "El estado no puede ser nulo")
    private Boolean estado;
}
