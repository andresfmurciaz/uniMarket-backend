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


//-------------Relaciones------------------------------


    @OneToMany(mappedBy = "moderador")
    private List<Producto_Moderador>producto_moderadors;




}
