package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Compra implements Serializable
{
    @Id
    //autoinclementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    //FECHA NO NULL Y QUE SE AUTO CREADA
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha_creacion;
    private float valor_total;
    //para dejar el atributo no null y con un tamaño de caracteres
    @Column(nullable = false , length = 100)
    private String medio_pago;

    public Compra(Integer codigo, LocalDateTime fecha_creacion, float valor_total, String medio_pago) {
        this.codigo = codigo;
        this.fecha_creacion = fecha_creacion;
        this.valor_total = valor_total;
        this.medio_pago = medio_pago;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "codigo=" + codigo +
                ", fecha_creacion=" + fecha_creacion +
                ", valor_total=" + valor_total +
                ", medio_pago='" + medio_pago + '\'' +
                ", usuario=" + usuario +
                '}';
    }
//-------------Relaciones------------------------------


    @OneToMany(mappedBy = "compra")
    @ToString.Exclude
    private List<Detalle_Compra>detalle_compras;

    @ManyToOne
    private Usuario usuario;



}
