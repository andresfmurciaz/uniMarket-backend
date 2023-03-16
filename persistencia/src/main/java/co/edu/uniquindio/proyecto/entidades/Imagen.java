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
public class Imagen implements Serializable
{
    @Id
    //autoinclementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_imagen;

    //una imagen tiene muchos productos
  //  @OneToMany (mappedBy = "imagen")
   // private List<Producto> productos;
    @ManyToOne
    private Producto producto;


}
