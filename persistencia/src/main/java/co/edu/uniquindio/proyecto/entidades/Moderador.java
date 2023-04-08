package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Moderador extends Persona implements Serializable {
    public Moderador(Integer codigo, String nombre, String email, String password ) {
        super(codigo, nombre, email, password);

    }


    //-------------Relaciones------------------------------


    @OneToMany(mappedBy = "moderador")
    private List<Producto_Moderador>producto_moderadors;




}
