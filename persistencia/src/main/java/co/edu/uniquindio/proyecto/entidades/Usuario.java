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
public class Usuario  extends Persona implements Serializable
{
        @Id
        //autoinclementable
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer codigo;


        //un USUARIO solo tiene un PRODUCTO
   //     @ManyToOne
    //    private Producto producto;


      //  @ManyToOne
       // private Compra compra;

        //@ManyToOne
        //private Comentario comentario;

        @OneToMany (mappedBy = "usuario")
        private List<Comentario> comentarios;

        @OneToMany (mappedBy = "usuario")
        private List<Producto> productosUser;

        @OneToMany (mappedBy = "usuario")
        private List<Compra> compras;

        @ManyToMany (mappedBy = "usuarios")
        private List<Producto> productos;


}
