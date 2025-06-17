
package gestionevaluaciones.com.gestion_evaluaciones.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CrearEvaluacionRequest {

    @NotNull
    private Integer idCurso;

    @NotNull
    @Size(min = 3, max = 100)
    private String titulo;

    @NotNull
    @Size(min = 5, max = 250)
    private String descripcion;

    @NotNull
    private String tipo;

    @NotNull
    private LocalDate fechaEntrega;

    @NotNull
    private Integer puntajeMaximo;

    private boolean activa;
}
