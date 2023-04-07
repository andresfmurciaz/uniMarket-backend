package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter

@NoArgsConstructor
@ToString
public class Usuario extends Persona implements Serializable
{
        @Column(nullable = false , length = 200)
        private String direccion;
        @Column(nullable = false , length = 10)
        private String telefono;

        public Usuario(String direccion, String telefono) {
                this.direccion = direccion;
                this.telefono = telefono;
        }

        


//-------------Relaciones------------------------------

        @ManyToMany
        private List<Producto> productos;


        @OneToMany(mappedBy = "usuario")
        private List<Producto> productos2;


        @OneToMany(mappedBy = "usuario")
        private List<Comentario> comentarios;



}
