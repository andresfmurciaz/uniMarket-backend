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
@Table
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
  //  @ManyToOne
   // private Categoria categoria;
    @OneToMany (mappedBy = "producto")
    private List<Categoria> categorias;

    //un producto solo tiene un imagen
  //  @ManyToOne
    //private Imagen imagen;
    @OneToMany (mappedBy = "producto")
    private List<Imagen> imagenes;


    //un producto solo tiene un detalle_compra
    //@ManyToOne
    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Detalle_Compra> detalleCompras;
    //un producto solo tiene un comentario
    //@ManyToOne
   // private Comentario comentario;


    //un producto solo tiene un moderador
   // @ManyToOne
   // private Producto_Moderador productoModerador;

    @OneToMany (mappedBy = "producto")
    private List<Producto_Moderador> productoModerador;

    @OneToMany (mappedBy = "producto")
    private List<Comentario> comentarios;



    //una usuario tiene muchos productos
    //@OneToMany (mappedBy = "producto")
    //private List<Usuario> usuario;


    @ManyToMany (mappedBy = "productos")
    private List<Usuario> usuarios;

    @ManyToOne
    private Usuario usuario;



}
