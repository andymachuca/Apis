
package gestionpago.com.gestion_pago.models;
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
    private Long id;

   
    private BigDecimal monto;
    private String metodo;
    private String descripcion;
    private String estado;
    private LocalDateTime fechaPago;

    @Column(name = "id_cliente")
    private Integer idCliente;

}
