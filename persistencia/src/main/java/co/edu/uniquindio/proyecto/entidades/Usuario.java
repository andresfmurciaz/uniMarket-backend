package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Usuario  extends Persona implements Serializable
{
        @Id
        //autoinclementable
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer codigo;


}
