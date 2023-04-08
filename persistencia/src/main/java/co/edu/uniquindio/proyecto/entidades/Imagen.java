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


    @Column(nullable = false , length = 100)
    private String ruta;

    public Imagen(Integer id_imagen, String ruta, Producto producto) {
        this.id_imagen = id_imagen;
        this.ruta = ruta;
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Imagen{" +
                "id_imagen=" + id_imagen +
                ", ruta='" + ruta + '\'' +
                ", producto=" + producto +
                '}';
    }

    //-------------Relaciones------------------------------
    @ManyToOne
    private Producto producto;

}
