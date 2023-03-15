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
public class Producto implements Serializable
{
    @Id
    //autoinclementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    //para dejar el atributo no null y con un tamaño de caracteres
    @Column(nullable = false , length = 100)
    private String nombre;
    private Integer unidades ;
    //para dejar el atributo no null y con un tamaño de caracteres
    @Column(nullable = false , length = 1000)
    private String descripcion;
    private float precio;

    @Column(nullable = false)
    private boolean activo;

    @Column(nullable = false)
    private LocalDate fecha_creado;

    @Column(nullable = false)
    private LocalDate fecha_limite;

    //un producto solo tiene una categoria
    @ManyToOne
    private Categoria categoria;
    //un producto solo tiene un imagen
    @ManyToOne
    private Imagen imagen;

    //un producto solo tiene un detalle_compra
    @ManyToOne
    private Detalle_Compra detalleCompra;

    //un producto solo tiene un comentario
    @ManyToOne
    private Comentario comentario;


    //un producto solo tiene un moderador
    @ManyToOne
    private Producto_Moderador productoModerador;


    //una usuario tiene muchos productos
    @OneToMany (mappedBy = "producto")
    private List<Usuario> usuario;




    @ManyToMany (mappedBy = "productos")
    private List<Usuario> usuarios;



}
