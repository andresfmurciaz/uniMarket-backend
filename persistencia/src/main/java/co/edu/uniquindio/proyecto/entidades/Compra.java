package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Compra implements Serializable
{
    @Id
    //autoinclementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    //FECHA NO NULL Y QUE SE AUTO CREADA
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha_creacion;
    private float valor_total;
    //para dejar el atributo no null y con un tamaño de caracteres
    @Column(nullable = false , length = 100)
    private String medio_pago;


    //duda
    //una compra solo tiene un detalle
    /*
    @ManyToOne
    private Detalle_Compra detalleCompra;
*/

    @OneToMany(mappedBy = "compra")
    @ToString.Exclude
    // private Detalle_Compra detalleCompra;
    private List<Detalle_Compra> detalleCompras;

    //una
    //@OneToMany (mappedBy = "compra")
    //private List<Usuario> usuarios;

    @ManyToOne
    private Usuario usuario;



}
