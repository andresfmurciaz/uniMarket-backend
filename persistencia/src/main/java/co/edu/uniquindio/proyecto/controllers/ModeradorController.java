package co.edu.uniquindio.proyecto.controllers;
import co.edu.uniquindio.proyecto.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.service.interfaces.ModeradorService;
import co.edu.uniquindio.proyecto.service.interfaces.UsuarioService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/moderador")
@AllArgsConstructor
public class ModeradorController {

    private final ModeradorService  moderadorServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearModerador(@Valid @RequestBody Moderador moderador) throws Exception
    {
        moderadorServicio.registrarModerador(moderador);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "El moderador se creó correctamente"));
    }

    @PutMapping("/actualizar/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> actualizarModerador(@PathVariable int codigo, @Valid @RequestBody Moderador moderador)throws Exception{
        moderadorServicio.actualizarModerador(moderador);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "El moderador se actualizó correctamente"));
    }

    @DeleteMapping("/eliminar/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> eliminarModerador(@PathVariable int codigo) throws Exception{
        moderadorServicio.eliminarModerador(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "el moderador eliminado correctamente"));
    }

    @GetMapping("/obtener/{codigoModerador}")
    public ResponseEntity<MensajeDTO> obtenerModerador(@PathVariable int codigo) throws Exception{
        moderadorServicio.obtenerModerador(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Se obtuvo el moderador correctamente"));
    }


}
