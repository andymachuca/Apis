package apigateway.com.api_gateway.jwt.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int id;

    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "rut")
    private String rut;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;
}
