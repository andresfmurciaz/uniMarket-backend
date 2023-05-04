package co.edu.uniquindio.proyecto.controllers;

import co.edu.uniquindio.proyecto.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.service.interfaces.UsuarioService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuariof")
@AllArgsConstructor
public class UsuarioController
{
    private final UsuarioService  usuarioServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearUsuario(@Valid @RequestBody Usuario usuario) throws Exception
    {
        usuarioServicio.registrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "El usuario se creó correctamente"));
    }

    @PutMapping("/actualizar/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> actualizarUsuario(@PathVariable int codigoUsuario, @Valid @RequestBody Usuario usuario)throws Exception{
        usuarioServicio.actualizarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "El usuario se actualizó correctamente"));
    }


    @DeleteMapping("/eliminar/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> eliminarUsuario(@PathVariable int codigoUsuario) throws Exception{
        usuarioServicio.eliminarUsuario(codigoUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Usuario eliminado correctamente"));
    }


    @GetMapping("/obtener/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> obtenerUsuario(@PathVariable int codigoUsuario) throws Exception{
        usuarioServicio.obtenerUsuario(codigoUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Se obtuvo el usuario correctamente"));
    }

}
