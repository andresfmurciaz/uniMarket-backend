package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Producto_Moderador implements Serializable
{
    @Id
    //autoinclementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    //para dejar el atributo no null y con un tamaño de caracteres
    @Column(nullable = false , length = 1000)
    private String motivo;
    //para dejar el atributo no null
    @Column(nullable = false)
    private LocalDate fecha;

    public Producto_Moderador(Integer codigo, String motivo, LocalDate fecha, Producto producto, Estado estado, Moderador moderador) {
        this.codigo = codigo;
        this.motivo = motivo;
        this.fecha = fecha;
        this.producto = producto;
        this.estado = estado;
        this.moderador = moderador;
    }

    //-------------Relaciones------------------------------

    @ManyToOne
    private Producto producto;


    @ManyToOne
    private Estado estado;
    @ManyToOne
    private Moderador moderador;


    @Override
    public String toString() {
        return "Producto_Moderador{" +
                "codigo=" + codigo +
                ", motivo='" + motivo + '\'' +
                ", fecha=" + fecha +
                ", producto=" + producto +
                ", estado=" + estado +
                ", moderador=" + moderador +
                '}';
    }

}
