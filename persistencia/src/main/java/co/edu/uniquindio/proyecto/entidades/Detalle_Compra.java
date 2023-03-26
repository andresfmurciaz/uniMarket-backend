package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Detalle_Compra implements Serializable
{
    @Id
    //autoinclementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    //para dejar el atributo no null
    @Column(nullable = false)
    private float precio_producto;
    @Positive
    //para dejar el atributo no null
    @Column(nullable = false)
    private Integer unidades;

//-------------Relaciones------------------------------

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private  Compra compra;





}
