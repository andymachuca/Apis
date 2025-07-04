
package gestionmatricula.com.gestion_matricula.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "matricula")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    
    private Boolean estado;
    
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "id_curso")
    private Integer idCurso;
}
