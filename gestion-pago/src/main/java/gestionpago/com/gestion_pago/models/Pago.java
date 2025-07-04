package gestionpago.com.gestion_pago.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único del pago", example = "1")
    private Long id;

    @Schema(description = "Monto del pago", example = "15000.00")
    private BigDecimal monto;

    @Schema(description = "Método de pago", example = "Transferencia")
    private String metodo;

    @Schema(description = "Descripción del pago", example = "Pago correspondiente al curso")
    private String descripcion;

    @Schema(description = "Estado del pago", example = "Completado")
    private String estado;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Schema(description = "Fecha del pago en formato ISO 8601", example = "2025-06-28T14:00:00")
    private LocalDateTime fechaPago;

    @Column(name = "id_cliente")
    @Schema(description = "ID del cliente asociado al pago", example = "123")
    private Integer idCliente;
}
