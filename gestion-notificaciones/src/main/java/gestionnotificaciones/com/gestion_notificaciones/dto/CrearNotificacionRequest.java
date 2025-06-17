
package gestionnotificaciones.com.gestion_notificaciones.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CrearNotificacionRequest {

    @NotNull
    private Integer idUsuario;

    @NotNull
    @Size(min = 3, max = 100)
    private String titulo;

    @NotNull
    @Size(min = 5, max = 500)
    private String mensaje;

    @NotNull
    private String tipo;

    private boolean leido;
}
