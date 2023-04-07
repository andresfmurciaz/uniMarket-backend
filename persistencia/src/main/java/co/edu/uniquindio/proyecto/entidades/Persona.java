package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@AllArgsConstructor
public class Persona implements Serializable {
    @Id
    @EqualsAndHashCode.Include
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    //para dejar el atributo no null y con un tamaño de caracteres
    @Column(nullable = false , length = 100)
    private String nombre;
    //para dejar el atributo no null , con un tamaño de caracteres y que sea unico
    @Column(nullable = false , length = 100, unique = true)
    private String email;
    //para dejar el atributo no null
    @Column(nullable = false)
    private String password;


    //-------------Relaciones------------------------------

}
