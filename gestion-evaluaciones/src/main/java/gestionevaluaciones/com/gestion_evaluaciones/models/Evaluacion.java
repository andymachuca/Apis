
package gestionevaluaciones.com.gestion_evaluaciones.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "evaluacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private String tipo;
    private LocalDate fechaEntrega;
    private Integer puntajeMaximo;
    private boolean activa;

    @Column(name = "id_curso")
    private Integer idCurso;
}
