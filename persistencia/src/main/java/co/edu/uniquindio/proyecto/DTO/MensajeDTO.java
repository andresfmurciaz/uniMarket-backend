package co.edu.uniquindio.proyecto.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class MensajeDTO {
    private HttpStatus estado;
    private boolean error;
    private String respuesta;
}
