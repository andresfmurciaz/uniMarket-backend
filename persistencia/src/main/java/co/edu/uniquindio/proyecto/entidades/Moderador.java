package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Moderador extends Persona implements Serializable {
    @Id
    //autoinclementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;


  //  @ManyToOne
   // private Producto_Moderador productoModerador;

    @OneToMany (mappedBy = "moderador")
    private List<Producto_Moderador> productoModerador;



}
