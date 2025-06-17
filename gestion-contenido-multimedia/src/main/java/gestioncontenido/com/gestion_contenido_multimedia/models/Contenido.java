
package gestioncontenido.com.gestion_contenido_multimedia.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contenido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String titulo;
    private String descripcion;
    private String url;
    private String tipo;
    private boolean activo;
    
    @Column(name = "id_curso")
    private Integer idCurso;
}
