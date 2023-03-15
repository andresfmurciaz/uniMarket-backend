package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Comentario implements Serializable
{
    @Id
    //autoinclementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    //para dejar el atributo no null y con un tamaño de caracteres
    @Column(nullable = false , length = 1000)
    private String mensaje;
    //FECHA NO NULL Y QUE SE AUTO CREADA
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate fecha_creacion;
}
