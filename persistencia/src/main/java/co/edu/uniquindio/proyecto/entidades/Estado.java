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
public class Estado implements Serializable
{
    @Id
    //autoinclementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    //para dejar el atributo no null y con un tamaño de caracteres
    @Column(nullable = false , length = 100)
    private String nombre;

    public Estado(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
    //-------------Relaciones------------------------------

    @OneToMany(mappedBy ="estado")
    private List<Producto_Moderador>producto_moderadors;






}
