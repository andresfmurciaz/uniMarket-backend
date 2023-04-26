package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;


@Entity
@Getter
@Setter

@NoArgsConstructor
@ToString
public class Usuario extends Persona implements Serializable
{

        private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        private static final int LENGTH = 10;

        private static final Random RANDOM = new SecureRandom();


        @Column(nullable = false , length = 200)
        private String direccion;
        @Column(nullable = false , length = 10)
        private String telefono;

        public Usuario(String direccion, String telefono) {
                this.direccion = direccion;
                this.telefono = telefono;
        }

        public Usuario(Integer codigo, String nombre, String email, String password, String direccion, String telefono) {
                super(codigo, nombre, email, password);
                this.direccion = direccion;
                this.telefono = telefono;
        }






        public static String generarRandomString() {
                StringBuilder sb = new StringBuilder(LENGTH);
                for (int i = 0; i < LENGTH; i++) {
                        sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
                }
                return sb.toString();
        }


        @Override
        public String toString() {
                return "Usuario{" +
                        "direccion='" + direccion + '\'' +
                        ", telefono='" + telefono + '\'' +
                        '}';
        }
        //-------------Relaciones------------------------------

        @ManyToMany
        private List<Producto> productos;


        @OneToMany(mappedBy = "usuario")
        @ToString.Exclude
        private List<Producto> productos2;


        @OneToMany(mappedBy = "usuario")
        @ToString.Exclude
        private List<Comentario> comentarios;

        @OneToMany(mappedBy = "usuario")
        @ToString.Exclude
        private List<Compra> compras;



}
