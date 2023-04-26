package co.edu.uniquindio.proyecto.controllers;
import co.edu.uniquindio.proyecto.DTO.MensajeDTO;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.service.interfaces.ProductoService;
import co.edu.uniquindio.proyecto.service.interfaces.UsuarioService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/producto")
@AllArgsConstructor
public class ProductoController {


    private final ProductoService productoServicio;


    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearProducto(@Valid @RequestBody Producto producto) throws Exception
    {
        productoServicio.registrarProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "El producto se creó correctamente"));
    }

    @PutMapping("/actualizar/{codigo}")
    public ResponseEntity<MensajeDTO> actualizarProducto(@PathVariable int codigo, @Valid @RequestBody Producto producto)throws Exception{
        productoServicio.actualizarProducto(producto);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "El producto se actualizó correctamente"));
    }

    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<MensajeDTO> eliminarProducto(@PathVariable int codigo) throws Exception{
        productoServicio.eliminarProducto(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "producto eliminado correctamente"));
    }

    @GetMapping("/obtener/{codig}")
    public ResponseEntity<MensajeDTO> obtenerProducto(@PathVariable int codigo) throws Exception{
        productoServicio.obtenerProducto(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Se obtuvo el producto correctamente"));
    }



}
