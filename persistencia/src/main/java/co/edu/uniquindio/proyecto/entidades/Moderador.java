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
public class Moderador extends Persona implements Serializable {
    public Moderador(Integer codigo, String nombre, String email, String password ) {
        super(codigo, nombre, email, password);
        this.producto_moderadors = producto_moderadors;
    }

//-------------Relaciones------------------------------


    @OneToMany(mappedBy = "moderador")
    private List<Producto_Moderador>producto_moderadors;




}
