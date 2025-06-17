
package gestionpago.com.gestion_pago.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CrearPagoRequest {

    @NotNull
    private Long usuarioId;

    @NotNull
    private BigDecimal monto;

    @NotNull
    private String metodo;

    @Size(max = 250)
    private String descripcion;

    @NotNull
    private String estado;
}
