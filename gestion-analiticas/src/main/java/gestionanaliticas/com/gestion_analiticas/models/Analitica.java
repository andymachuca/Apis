
package gestionanaliticas.com.gestion_analiticas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "analitica")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Analitica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    
    private String tipo;
    private String descripcion;
    private LocalDateTime fechaEvento;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "id_curso")
    private Integer idCurso;

}
