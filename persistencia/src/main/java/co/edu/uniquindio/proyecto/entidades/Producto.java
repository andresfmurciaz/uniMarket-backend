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


    private Integer activo;

    @Column(nullable = false)
    private LocalDate fecha_creado;

    @Column(nullable = false)
    private LocalDate fecha_limite;


    public Producto(Integer codigo, String nombre, Integer unidades, String descripcion, float precio, Integer activo, LocalDate fecha_creado, LocalDate fecha_limite, Usuario usuario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.precio = precio;
        this.activo = activo;
        this.fecha_creado = fecha_creado;
        this.fecha_limite = fecha_limite;
        this.usuario = usuario;
    }

    @Override
    public String toString()
    {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", unidades=" + unidades +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", activo=" + activo +
                ", fecha_creado=" + fecha_creado +
                ", fecha_limite=" + fecha_limite +
                ", usuario=" + usuario +
                '}';
    }

    //-------------Relaciones------------------------------
    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Imagen> imagenes;


    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Categoria> categorias;


    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Detalle_Compra> detalle_compras;


    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Producto_Moderador> producto_moderadores;


    @ManyToMany(mappedBy = "productos")
    private List<Usuario> usuarios;


    @ManyToOne
    private Usuario usuario;



}
