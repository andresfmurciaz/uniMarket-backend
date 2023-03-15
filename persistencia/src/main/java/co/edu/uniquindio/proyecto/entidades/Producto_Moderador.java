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


    //un productoModerador tiene muchos productos
    @OneToMany (mappedBy = "productoModerador")
    private List<Producto> productos;


    //un productoModerador tiene muchos productos
    @OneToMany (mappedBy = "productoModerador")
    private List<Moderador> moderadores;


    //un productoModerador tiene muchos productos
    @OneToMany (mappedBy = "productoModerador")
    private List<Estado> estados;




}
